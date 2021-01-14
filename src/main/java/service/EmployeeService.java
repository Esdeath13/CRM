package service;

import entity.Customer;
import entity.Employee;
import entity.Information;
import vo.employeeVo;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/4 12:24
 **/
public interface EmployeeService {
    /**
     * 查询所有员工
     *
     * @return List<Information>
     */
    List<Employee> selectAll();

    /**
     * 查询所有
     *
     * @return List<Information>
     */
    List<employeeVo> showAll();
    /**
     * 新增
     *
     * @param employee 对象
     * @return int
     */
    int insertEmployee(Employee employee);
    /**
     * 删除学生
     *
     * @param id id
     * @return int
     */
    int deleteById(String id);
    /**
     *
     * 根据account查询信息
     *
     * @param  account account
     * @return List<Employee>
     */
    List<Employee> selectByAccount(String account);
}
