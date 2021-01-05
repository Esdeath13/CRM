package dao.impl;

import dao.CustomerDao;
import entity.Customer;
import utils.JdbcUtil;
import vo.customerVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomerDaoImpl
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/30 8:41
 **/
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<customerVo> selectAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.i_content,t3.p_name\n" +
                "FROM customer t1\n" +
                "LEFT JOIN information t2\n" +
                "ON t1.c_id = t2.c_id\n" +
                "LEFT JOIN product t3 \n" +
                "on t2.p_id = t3.p_id";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<customerVo> customerList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return  customerList;
    }

    @Override
    public int insertCustomer(Customer customer) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, customer.getId());
        pstmt.setString(2, customer.getName());
        pstmt.setString(3, customer.getPhone());
        pstmt.setString(4, customer.getAdress());
        pstmt.setString(5, customer.getCredit());
        pstmt.setString(6, customer.getP_id());
        pstmt.setObject(7, customer.getC_time());
        pstmt.setString(8, customer.getE_id());
        int n = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return n;
    }

    @Override
    public int deleteById(String id) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "DELETE FROM customer WHERE c_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return n;
    }

    private List<customerVo> convert(ResultSet rs) throws SQLException {
        List<customerVo> list = new ArrayList<>();
        while (rs.next()) {
            customerVo customer = customerVo.builder()
                    .id(rs.getInt("c_id"))
                    .name(rs.getString("c_name"))
                    .phone((rs.getString("c_phone")))
                    .adress(rs.getString("c_adress"))
                    .credit(rs.getString("c_credit"))
                    .p_id(rs.getInt("p_id"))
                    .time(rs.getDate("c_time"))
                    .e_id(rs.getInt("e_id"))
                    .build();
            list.add(customer);
        }
        return list;
    }
}
