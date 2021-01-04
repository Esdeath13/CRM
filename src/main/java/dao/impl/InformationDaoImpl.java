package dao.impl;

import dao.InformationDao;
import entity.Information;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InformationDaoImpl
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/31 13:53
 **/
public class InformationDaoImpl implements InformationDao {
    @Override
    public List<Information> selectByCustomerId(int customerId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM information WHERE p_id ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, customerId);
        ResultSet rs = pstmt.executeQuery();
        List<Information> informationList = new ArrayList<>();
        while (rs.next()){
            Information information = new Information();
            information.setId(rs.getInt("i_id"));
            information.setC_id(rs.getString("c_id"));
            information.setTime(rs.getDate("i_time"));
            information.setContent(rs.getString("i_content"));
            information.setP_id(rs.getString("p_id"));
            information.setResult(rs.getInt("i_result"));
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return informationList;
    }

    @Override
    public List<Information> selectAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM information WHERE p_id ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Information> informationList = new ArrayList<>();
        while (rs.next()){
            Information information = new Information();
            information.setId(rs.getInt("i_id"));
            information.setC_id(rs.getString("c_id"));
            information.setTime(rs.getDate("i_time"));
            information.setContent(rs.getString("i_content"));
            information.setP_id(rs.getString("p_id"));
            information.setResult(rs.getInt("i_result"));
            informationList.add(information);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return informationList;
    }
}
