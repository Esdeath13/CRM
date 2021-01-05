package dao;

import entity.Customer;
import factory.DaoFactory;
import factory.ServiceFactory;
import org.junit.Test;
import service.CustomerService;
import vo.customerVo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoTest {
    private final CustomerDao customerDao = DaoFactory.getCustomerDaoInstance();

    @Test
    public void selectAll() throws SQLException {
        List<customerVo> list = DaoFactory.getCustomerDaoInstance().selectAll();
        list.forEach(System.out::println);
    }
    @Test
    public void insert() throws SQLException {
        Customer customer = new Customer();
        customer.setId("3");
        customer.setName("涛涛");
        customer.setPhone("17368686016");
        customer.setAdress("镇江");
        customer.setCredit("好");
        customer.setP_id("50");
        customer.setC_time(new Date());
        customer.setE_id("20");
        int n = customerDao.insertCustomer(customer);
        assertEquals(1, n);
    }
    @Test
    public void deleteById() throws SQLException {
        int n = customerDao.deleteById("22");
        assertEquals(1, n);
    }
}



