package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.Book;

public class BookDAO {
    private JDBCUtil jdbcUtil = null;
    
    public BookDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
    }
    
    // 책 등록
    public int create(Book book) throws SQLException {
        String sql = "INSERT INTO Book VALUES (?, ?, ?, ?, ?, ?)";      
        Object[] param = new Object[] {book.getBookId(), book.getBookTitle(), 
                book.getCategory(), book.getAuthor(), book.getPublisher(), book.getPublishDate(),
                book.getDescription(), book.getBookImg() };              
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
                        
        try {               
            int result = jdbcUtil.executeUpdate();  // insert 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;       
    }
    
    //책 정보 수정
    public int update(Book book) throws SQLException { 
        String sql = "UPDATE Book "
                + "SET bookTitle=?, category=?, author=?, publisher=?, publishedDate=?, description=?, bookImg=? "
                + "WHERE bookid=?";
        Object[] param = new Object[] {
                book.getBookTitle(), book.getCategory(), book.getAuthor(), book.getPublisher(),
                book.getPublishDate(), book.getDescription(), book.getBookImg(),
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
                    rs.getString("bookId"),
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
    
}