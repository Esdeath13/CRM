package dao;

import entity.Customer;
import entity.Employee;
import factory.DaoFactory;
import org.junit.Test;
import vo.customerVo;
import vo.employeeVo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoTest {
    private final EmployeeDao employeeDao = DaoFactory.getEmployeeDaoInstance();

    @Test
    public void selectAll() throws SQLException {
        List<Employee> list = DaoFactory.getEmployeeDaoInstance().selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void showAll() throws SQLException {
        List<employeeVo> list = DaoFactory.getEmployeeDaoInstance().showAll();
        list.forEach(System.out::println);
    }
    @Test
    public void insert() throws SQLException {
        Employee employee = new Employee();
        employee.setId("3");
        employee.setName("涛涛");
        employee.setDepartment("外联部");
        employee.setType("2");
        employee.setT_id("1");
        employee.setSalary(5000f);

        int n = employeeDao.insertEmployee(employee);
        assertEquals(1, n);
    }
    @Test
    public void deleteById() throws SQLException {
        int n = employeeDao.deleteById("3");
        assertEquals(1, n);
    }
    @Test
    public void selectByAccount() throws Exception {
        List<Employee> list = employeeDao.selectByAccount("涛涛");
        System.out.println(list);
    }
}