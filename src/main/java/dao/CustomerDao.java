package dao;

import entity.Customer;
import vo.ShowCustomerVo;
import vo.customerVo;
import vo.employeeVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CustomerDao
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/30 8:39
 **/
public interface CustomerDao {
    /**
     * 查询所有信息
     *
     * @return
     * @throws SQLException
     */

    List<customerVo> selectAll() throws SQLException;

    /**
     * 插入客户
     *
     * @param customer 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertCustomer(Customer customer) throws SQLException;
    /**
     * 根据id删除
     *
     * @param id id
     * @return int
     * @throws SQLException 异常
     */
    int deleteById(String id) throws SQLException;
    /**
     * 查询员工所有信息
     *
     * @return
     * @throws SQLException
     */

    List<ShowCustomerVo> showAll() throws SQLException;

}
