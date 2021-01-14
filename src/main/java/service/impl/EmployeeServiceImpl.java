package service.impl;

import dao.CustomerDao;
import dao.EmployeeDao;
import entity.Customer;
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
    private final EmployeeDao employeeDao = DaoFactory.getEmployeeDaoInstance();
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

    @Override
    public int insertEmployee(Employee employee) {
        int n = 0;
        try {
            n = employeeDao.insertEmployee(employee);
        } catch (SQLException e) {
            System.err.println("新增用户出现异常");
        }
        return n;
    }

    @Override
    public int deleteById(String id) {
        int n = 0;
        try {
            n = employeeDao.deleteById(id);
        } catch (SQLException e) {
            System.err.println("删除学生出现异常");
        }
        return n;
    }

    @Override
    public List<Employee> selectByAccount(String account) {
        List<Employee> list = null;
        try {
            list = DaoFactory.getEmployeeDaoInstance().selectByAccount(account);
        }catch (SQLException e){
            System.err.println("根据account查询信息出错");
        }
        return list;
    }
}
