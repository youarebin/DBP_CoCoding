package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.User;
import model.domain.Book;

public class UserDAO {
    private JDBCUtil jdbcUtil = null;
    
    public UserDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
    }

    // 회원 등록
    public int create(User user) throws SQLException {
        String sql = "INSERT INTO User (userId, password, name, email, nickName, account, phoneNumber, profileImage) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[]{
            user.getUserId(),
            user.getPassword(),
            user.getName(),
            user.getEmail(),
            user.getNickName(),
            user.getAccount(),
            user.getPhoneNumber(),
            user.getProfileImage()
        };
        jdbcUtil.setSqlAndParameters(sql, param);

        try {
            return jdbcUtil.executeUpdate();  // insert 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
        return 0;
    }

    // 회원 정보 수정
    public int update(User user) throws SQLException {
        String sql = "UPDATE User SET password=?, name=?, email=?, nickName=?, account=?, phoneNumber=?, profileImage=? WHERE userId=?";
        Object[] param = new Object[]{
            user.getPassword(),
            user.getName(),
            user.getEmail(),
            user.getNickName(),
            user.getAccount(),
            user.getPhoneNumber(),
            user.getProfileImage(),
            user.getUserId()
        };
        jdbcUtil.setSqlAndParameters(sql, param);

        try {
            return jdbcUtil.executeUpdate();  // update 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
        return 0;
    }

    // 해당 회원 삭제(탈퇴)
    public int delete(String userId) throws SQLException {
        String sql = "DELETE FROM User WHERE userId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{userId});

        try {
            return jdbcUtil.executeUpdate();  // delete 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
        return 0;
    }

    // 회원이 판매한 책 리스트 반환
    public List<Book> getSellingBookList(String userId) throws SQLException {
        String sql = "SELECT * FROM Book WHERE sellerId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{userId});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("bookId"));;
                book.setBookTitle(rs.getString("bookTitle"));
                book.setCategory(rs.getString("category"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublishedDate(rs.getDate("publishedDate"));
                book.setBookImg(rs.getString("bookImg"));
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

    // 회원이 구매한 책 리스트 반환
    public List<Book> getPurchaseBookList(String userId) throws SQLException {
        String sql = "SELECT b.* FROM Book b JOIN Purchase p ON b.bookId = p.bookId WHERE p.userId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{userId});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("bookId"));
                book.setBookTitle(rs.getString("bookTitle"));
                book.setCategory(rs.getString("category"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublishedDate(rs.getDate("publishedDate"));
                book.setBookImg(rs.getString("bookImg"));
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
    
    //회원 찾기
    public User findUser(String userId) throws SQLException {
        String sql = "SELECT password, name, email, nickName, account, phoneNumber, profileImage "
                    + "FROM User "
                    + "WHERE userid=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});   // JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();     // query 실행
            if (rs.next()) {                        // 학생 정보 발견
                User user = new User(       // User 객체를 생성하여 학생 정보를 저장
                    userId,
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("nickName"),
                    rs.getString("account"),                    
                    rs.getString("phoneNumber"), 
                    rs.getString("profileImage"));
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }
    
}
