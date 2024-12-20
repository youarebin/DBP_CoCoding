package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.domain.Book;
import model.domain.BookApplicant;

public class BookDAO {
    private JDBCUtil jdbcUtil = null;
    
    public BookDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
    }
    
    // 책 등록
    public int create(Book book) throws SQLException {
        int result = 0;

        try {
            // Book 테이블에 삽입
            String sql = "INSERT INTO Book (bookTitle, category, author, publisher, publishedDate, "
                    + "bookImg, customerId, desiredLocation, desiredPrice, usagePeriod) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] bookParams = new Object[] {
                book.getBookTitle(),
                book.getCategory(),
                book.getAuthor(),
                book.getPublisher(),
                new java.sql.Date(book.getPublishedDate().getTime()),
                book.getBookImg(),
                book.getCustomerId(),
                book.getDesiredLocation(),
                book.getDesiredPrice(),
                book.getUsagePeriod()
            };
            jdbcUtil.setSqlAndParameters(sql, bookParams); // Book SQL 설정
            result = jdbcUtil.executeUpdate(); // Book 테이블 삽입 실행
        } catch (Exception ex) {
            jdbcUtil.rollback(); // 트랜잭션 롤백
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit(); // 트랜잭션 커밋
            jdbcUtil.close(); // 자원 반환
        }

        return result; // 삽입 결과 반환
    }

    
    //책 정보 수정
    public int update(Book book) throws SQLException { 
        String sql = "UPDATE Book "
                + "SET bookTitle=?, category=?, author=?, publisher=?, publishedDate=?, bookImg=? "
                + "WHERE bookid=?";
        Object[] param = new Object[] {
                book.getBookTitle(), book.getCategory(), book.getAuthor(), book.getPublisher(),
                book.getPublishedDate(), book.getBookImg(),
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
                    rs.getDate("publishedDate"), 
                    rs.getString("bookImg"),
                    rs.getInt("customerId"),
                    rs.getString("desiredLocation"),
                    rs.getString("desiredPrice"),
                    rs.getString("usagePeriod") );
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
        Book book = null;
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) { // 첫 번째 결과가 있으면
                book = new Book(
                        rs.getInt("bookId"),
                        rs.getString("bookTitle"),
                        rs.getString("category"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publishedDate"),
                        rs.getString("bookImg"),
                        rs.getInt("customerId"),
                        rs.getString("desiredLocation"),
                        rs.getString("desiredPrice"),
                        rs.getString("usagePeriod")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return book;
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
    
    // 책 신청자 등록
    public int insertApplicant(BookApplicant applicant) {
        int result = 0;
        
        try {
            String sql = "INSERT INTO BookApplicant (bookId, customerId, name, email, "
                    + "applicationDate, desiredPrice, desiredLocation, description) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            
            Object[] params = new Object[] {
                    applicant.getBookId(),
                    applicant.getCustomerId(),
                    applicant.getName(),
                    applicant.getEmail(),
                    applicant.getApplicationDate(),
                    applicant.getDesiredPrice(),
                    applicant.getDesiredLocation(),
                    applicant.getDescription()
            };
            
            jdbcUtil.setSqlAndParameters(sql, params); // SQL 설정
            result = jdbcUtil.executeUpdate(); // 실행
            
        } catch (Exception ex) {
            jdbcUtil.rollback(); // 트랜잭션 롤백
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit(); // 트랜잭션 커밋
            jdbcUtil.close(); // 자원 반환
        }

        return result;
    }
    
    //구매한 책 리스트 가져오기
    public List<Book> getPurchasedBookList(int customerId) {
        String query = "SELECT b.* " +
                       "FROM Book b " +
                       "JOIN BookApplicant ba ON b.bookId = ba.bookId " +
                       "WHERE ba.customerId = ?";

        jdbcUtil.setSqlAndParameters(query, new Object[]{customerId});
        
        List<Book> purchasedBookList = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Book book = new Book(           // Book 객체를 생성하여 현재 행의 정보를 저장
                        rs.getInt("bookId"),
                        rs.getString("bookTitle"),
                        rs.getString("category"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publishedDate"), 
                        rs.getString("bookImg"),
                        rs.getInt("customerId"),
                        rs.getString("desiredLocation"),
                        rs.getString("desiredPrice"),
                        rs.getString("usagePeriod") );
                purchasedBookList.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // 로깅 또는 예외 처리 추가 가능
        } finally {
            jdbcUtil.close();
        }
        return purchasedBookList; // null 대신 빈 리스트 반환
    }
    
    //판매(등록)한 책 리스트 가져오기
    public List<Book> getSoldBookList(int customerId) {
        String query = "SELECT * FROM Book WHERE customerId = ?";
        jdbcUtil.setSqlAndParameters(query, new Object[]{customerId});

        List<Book> soldBookList = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Book book = new Book(           // Book 객체를 생성하여 현재 행의 정보를 저장
                        rs.getInt("bookId"),
                        rs.getString("bookTitle"),
                        rs.getString("category"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publishedDate"), 
                        rs.getString("bookImg"),
                        rs.getInt("customerId"),
                        rs.getString("desiredLocation"),
                        rs.getString("desiredPrice"),
                        rs.getString("usagePeriod") );
                soldBookList.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // 로깅 또는 예외 처리 추가 가능
        } finally {
            jdbcUtil.close();
        }
        return soldBookList; // null 대신 빈 리스트 반환
    }

    // ResultSet의 현재 행을 Book 객체로 매핑
    private Book mapRowToBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("bookId"));
        book.setBookTitle(rs.getString("bookTitle"));
        book.setCategory(rs.getString("category"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setPublishedDate(rs.getDate("publishedDate"));
        book.setBookImg(rs.getString("bookImg"));
        return book;
    }
}
