package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.User;

public class UserDAO {
    private JDBCUtil jdbcUtil = null;
    
    public UserDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
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