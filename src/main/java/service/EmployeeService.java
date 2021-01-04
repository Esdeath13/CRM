package service;

import entity.Employee;
import entity.Information;

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
}
