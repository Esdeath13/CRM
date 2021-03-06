package dao.impl;

import dao.CustomerDao;
import entity.Customer;
import utils.JdbcUtil;
import vo.ShowCustomerVo;
import vo.customerVo;
import vo.employeeVo;

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

    @Override
    public List<ShowCustomerVo> showAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT c_id, c_name, c_phone, c_adress,c_credit, p_id, c_time, p_name, p_price\n " +
                "FROM customer NATURAL JOIN product ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<ShowCustomerVo> ShowCustomerVoList = convert2(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return ShowCustomerVoList;
    }

    @Override
    public List<Customer> selectByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM customer WHERE c_name = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        List<Customer> list = convert1(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    private List<Customer> convert1(ResultSet rs) throws SQLException {
        List<Customer> list = new ArrayList<>();
        while (rs.next()) {
            Customer customer = Customer.builder()
                    .id(rs.getString("c_id"))
                    .name(rs.getString("c_name"))
                    .phone((rs.getString("c_phone")))
                    .adress(rs.getString("c_adress"))
                    .credit(rs.getString("c_credit"))
                    .p_id(rs.getString("p_id"))
                    .c_time(rs.getDate("c_time"))
                    .e_id(rs.getString("e_id"))
                    .build();
            list.add(customer);
        }
        return list;
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
                    .p_name(rs.getString("p_name"))
                    .time(rs.getDate("c_time"))
                    .e_id(rs.getInt("e_id"))
                    .build();
            list.add(customer);
        }
        return list;
    }
    private List<ShowCustomerVo> convert2(ResultSet rs) throws SQLException {
        List<ShowCustomerVo> ShowCustomerVoList = new ArrayList<>();
        while (rs.next()) {
            ShowCustomerVo showCustomer = new ShowCustomerVo();
            showCustomer.setId(rs.getString("c_id"));
            showCustomer.setName(rs.getString("c_name"));
            showCustomer.setPhone(rs.getString("c_phone"));
            showCustomer.setAdress(rs.getString("c_adress"));
            showCustomer.setCredit(rs.getString("c_credit"));
            showCustomer.setP_id(rs.getString("p_id"));
            showCustomer.setC_time(rs.getDate("c_time"));
            showCustomer.setP_name(rs.getString("p_name"));
            showCustomer.setP_price(rs.getString("p_price"));

            ShowCustomerVoList.add(showCustomer);
        }
        return ShowCustomerVoList;
    }
}
