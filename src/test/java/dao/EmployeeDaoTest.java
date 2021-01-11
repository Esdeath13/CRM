package dao;

import entity.Employee;
import factory.DaoFactory;
import org.junit.Test;
import vo.customerVo;
import vo.employeeVo;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoTest {
    private final EmployeeDao mployeeDao = DaoFactory.getEmployeeDaoInstance();

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
}