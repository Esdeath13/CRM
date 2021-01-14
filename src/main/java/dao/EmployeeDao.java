package dao;

import entity.Customer;
import entity.Employee;
import vo.customerVo;
import vo.employeeVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName EmployeeDao
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/4 12:09
 **/
public interface EmployeeDao {
    /**
     * 查询所有员工
     *
     * @return List<Employee>
     * @throws SQLException 异常
     */
    List<Employee> selectAll() throws SQLException;

    /**
     * 查询员工所有信息
     *
     * @return
     * @throws SQLException
     */

    List<employeeVo> showAll() throws SQLException;
    /**
     * 插入员工
     *
     * @param employee 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertEmployee(Employee employee) throws SQLException;
    /**
     * 根据id删除
     *
     * @param id id
     * @return int
     * @throws SQLException 异常
     */
    int deleteById(String id) throws SQLException;
    /**
     * 按照名字查询
     *
     * @param account id
     * @return List<Employee>
     * @throws SQLException 异常
     */
    List<Employee> selectByAccount(String account) throws SQLException;
}
