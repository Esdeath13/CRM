package dao.impl;

import dao.EmployeeDao;
import entity.Employee;
import utils.JdbcUtil;

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
}
