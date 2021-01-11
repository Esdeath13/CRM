package service;

import entity.Customer;
import vo.ShowCustomerVo;
import vo.customerVo;
import vo.employeeVo;

import java.util.List;

/**
 * @ClassName CustomerService
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/30 9:02
 **/
public interface CustomerService {
    /**
     * 查询所有用户
     *
     * @return  List<Customer>
     */
    List<customerVo> selectAll();
    /**
     * 新增
     *
     * @param customer 对象
     * @return int
     */
    int insertCustomer(Customer customer);
    /**
     * 删除学生
     *
     * @param id id
     * @return int
     */
    int deleteById(String id);
    /**
     * 查询所有
     *
     * @return List<Information>
     */
    List<ShowCustomerVo> showAll();
}
