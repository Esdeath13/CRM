package dao.impl;

import dao.EmployeeDao;
import entity.Employee;
import utils.JdbcUtil;
import vo.employeeVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EmployeeDaoImpl
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/4 12:10
 **/
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> selectAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM employee ORDER BY e_id desc ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Employee> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<employeeVo> showAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT e_id, e_name, e_department, e_type, t_id, e_salary, t_quantity, t_profit\n" +
                "FROM employee NATURAL JOIN task ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<employeeVo> employeeVoList = convert1(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return employeeVoList;
    }

    private List<Employee> convert(ResultSet rs) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getString(("e_id")));
            employee.setT_id(rs.getString(("t_id")));
            employee.setName(rs.getString(("e_name")));
            employee.setDepartment(rs.getString(("e_department")));
            employee.setType(rs.getString(("e_type")));
            employee.setSalary(rs.getFloat(("e_salary")));
            employeeList.add(employee);
        }
        return employeeList;
    }

    private List<employeeVo> convert1(ResultSet rs) throws SQLException {
        List<employeeVo> employeeVoList = new ArrayList<>();
        while (rs.next()) {
            employeeVo employee = new employeeVo();
            employee.setE_id(rs.getString("e_id"));
            employee.setE_name(rs.getString("e_name"));
            employee.setE_department(rs.getString("e_department"));
            employee.setE_type(rs.getString("e_type"));
            employee.setT_id(rs.getString("t_id"));
            employee.setE_salary(rs.getString("e_salary"));
            employee.setT_quantity(rs.getString("t_quantity"));
            employee.setT_profit(rs.getString("t_profit"));

            employeeVoList.add(employee);
        }
        return employeeVoList;
    }
}
