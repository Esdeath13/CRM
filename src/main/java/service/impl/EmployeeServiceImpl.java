package service.impl;

import entity.Employee;
import factory.DaoFactory;
import service.EmployeeService;
import vo.employeeVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName EmployeeServiceImpl
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/4 12:25
 **/
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> selectAll() {
        List<Employee> list = null;
        try {
            list = DaoFactory.getEmployeeDaoInstance().selectAll();
        } catch (SQLException e) {
            System.err.println("查询所有员工出现异常");
        }
        return list;
    }

    @Override
    public List<employeeVo> showAll() {
        List<employeeVo> list = null;
        try {
            list = DaoFactory.getEmployeeDaoInstance().showAll();
        } catch (SQLException e) {
            System.err.println("查询员工出现异常");
        }
        return list;
    }
}
