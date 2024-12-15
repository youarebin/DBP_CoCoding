package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.Book;
import model.domain.RegistrationEntity;

public class BookDAO {
    private JDBCUtil jdbcUtil = null;
    
    public BookDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
    }
    
    // 책 등록
    public int create(Book book, RegistrationEntity registration) throws SQLException {
        int result = 0;

        try {
            // Book 테이블에 삽입
            String bookSql = "INSERT INTO Book (bookId, bookTitle, category, author, publisher, publishedDate, description, bookImg) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] bookParams = new Object[] {
                book.getBookId(),
                book.getBookTitle(),
                book.getCategory(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublishedDate(),
                book.getDescription(),
                book.getBookImg()
            };
            jdbcUtil.setSqlAndParameters(bookSql, bookParams); // Book SQL 설정
            result += jdbcUtil.executeUpdate(); // Book 테이블 삽입 실행

            // Registration 테이블에 삽입
            String registrationSql = "INSERT INTO Registration (bookId, customerId, registrationDate, desiredLocation, usagePeriod, desiredPrice) "
                                    + "VALUES (?, ?, ?, ?, ?, ?)";
            Object[] registrationParams = new Object[] {
                book.getBookId(), // bookId는 Book 객체에서 가져옴
                registration.getCustomerId(),
                registration.getRegistrationDate(),
                registration.getDesiredLocation(),
                registration.getUsagePeriod(),
                registration.getDesiredPrice()
            };
            jdbcUtil.setSqlAndParameters(registrationSql, registrationParams); // Registration SQL 설정
            result += jdbcUtil.executeUpdate(); // Registration 테이블 삽입 실행

            jdbcUtil.commit(); // 트랜잭션 커밋
        } catch (Exception ex) {
            jdbcUtil.rollback(); // 트랜잭션 롤백
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // 자원 반환
        }

        return result; // 삽입 결과 반환
    }

    
    //책 정보 수정
    public int update(Book book) throws SQLException { 
        String sql = "UPDATE Book "
                + "SET bookTitle=?, category=?, author=?, publisher=?, publishedDate=?, description=?, bookImg=? "
                + "WHERE bookid=?";
        Object[] param = new Object[] {
                book.getBookTitle(), book.getCategory(), book.getAuthor(), book.getPublisher(),
                book.getPublishedDate(), book.getDescription(), book.getBookImg(),
                book.getBookId()        
        };              
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
            
        try {               
            int result = jdbcUtil.executeUpdate();  // update 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }
    
    //책 삭제
    public int delete(String bookId) throws SQLException { 
        String sql = "DELETE FROM Book WHERE bookid=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {bookId});
        
        try {               
            int result = jdbcUtil.executeUpdate();  // delete 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }
    
    //모든 책 리스트 return
    public List<Book> getBookList() { 
        String sql = "SELECT * FROM Book ";
        jdbcUtil.setSqlAndParameters(sql, null);        // JDBCUtil에 query문 설정
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();        
            List<Book> bookList = new ArrayList<Book>(); //BookList 생성
            
            while (rs.next()) {
                Book book = new Book(           // Book 객체를 생성하여 현재 행의 정보를 저장
                    rs.getInt("bookId"),
                    rs.getString("bookTitle"),
                    rs.getString("category"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("publishedDate"),
                    rs.getString("description"),
                    rs.getString("bookImg") );
                bookList.add(book);             // List에 Book 객체 저장
            }       
            return bookList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }

    // 검색어로 책 리스트 반환
    public List<Book> searchBook(String keyword) {
        String query = "SELECT * FROM Book WHERE bookTitle LIKE ? OR category LIKE ? OR author LIKE ?";
        jdbcUtil.setSqlAndParameters(query, new Object[]{"%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%"});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = mapRowToBook(rs);
                bookList.add(book);
            }
            return bookList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 특정 bookId로 책 정보 반환
    public Book getBookInfo(int bookId) {
        String query = "SELECT * FROM Book WHERE bookId = ?";
        jdbcUtil.setSqlAndParameters(query, new Object[]{bookId});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                return mapRowToBook(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 가격 범위에 따라 책 리스트 반환
    public List<Book> getBookListByPrice(int minPrice, int maxPrice) {
        String query = "SELECT * FROM Book JOIN Registration ON Book.bookId = Registration.bookId WHERE desiredPrice BETWEEN ? AND ?";
        jdbcUtil.setSqlAndParameters(query, new Object[]{minPrice, maxPrice});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = mapRowToBook(rs);
                bookList.add(book);
            }
            return bookList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 지역에 따라 책 리스트 반환
    public List<Book> getBookListByLocation(String location) {
        String query = "SELECT * FROM Book JOIN Registration ON Book.bookId = Registration.bookId WHERE desiredLocation = ?";
        jdbcUtil.setSqlAndParameters(query, new Object[]{location});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = mapRowToBook(rs);
                bookList.add(book);
            }
            return bookList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 저자에 따라 책 리스트 반환
    public List<Book> getBookListByAuthor(String author) {
        String query = "SELECT * FROM Book WHERE author = ?";
        jdbcUtil.setSqlAndParameters(query, new Object[]{author});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = mapRowToBook(rs);
                bookList.add(book);
            }
            return bookList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // ResultSet의 현재 행을 Book 객체로 매핑
    private Book mapRowToBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("bookId"));
        book.setBookTitle(rs.getString("bookTitle"));
        book.setCategory(rs.getString("category"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setPublishedDate(rs.getString("publishedDate"));
        book.setDescription(rs.getString("description"));
        book.setBookImg(rs.getString("bookImg"));
        return book;
    }
}
