package dao.impl;

import dao.UserDao;
import entity.User;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName AdminDaoImpl
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:32
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM user WHERE account = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String adminAccount = rs.getString("account");
            String password = rs.getString("password");
            int type = rs.getInt("type");
            user = new User();
            user.setId(id);
            user.setAccount(adminAccount);
            user.setPassword(password);
            user.setType(type);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return user;
    }
}
