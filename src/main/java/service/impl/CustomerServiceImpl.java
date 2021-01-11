package service.impl;

import dao.CustomerDao;
import entity.Customer;
import factory.DaoFactory;
import service.CustomerService;
import vo.ShowCustomerVo;
import vo.customerVo;
import vo.employeeVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CustomerServiceImpl
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/30 9:03
 **/
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao = DaoFactory.getCustomerDaoInstance();

    @Override
    public List<customerVo> selectAll(){
        List<customerVo> customerList = null;
        try {
            customerList = customerDao.selectAll();
        }catch (SQLException e){
            System.err.println("查询用户信息出现异常");
        }
        return customerList;
    }

    @Override
    public int insertCustomer(Customer customer) {
        int n = 0;
        try {
            n = customerDao.insertCustomer(customer);
        } catch (SQLException e) {
            System.err.println("新增用户出现异常");
        }
        return n;
    }

    @Override
    public int deleteById(String id) {
        int n = 0;
        try {
            n = customerDao.deleteById(id);
        } catch (SQLException e) {
            System.err.println("删除学生出现异常");
        }
        return n;
    }

    @Override
    public List<ShowCustomerVo> showAll() {
        List<ShowCustomerVo> list = null;
        try {
            list = DaoFactory.getCustomerDaoInstance().showAll();
        } catch (SQLException e) {
            System.err.println("查询用户出现异常");
        }
        return list;
    }
}
