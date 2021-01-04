package service;

import entity.Customer;
import factory.ServiceFactory;
import org.junit.Test;
import vo.customerVo;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceTest {

    private final CustomerService customerService = ServiceFactory.getCustomerSeriviceInstance();

    @Test
    public void selectAll() {
        List<customerVo> customerList = customerService.selectAll();
        customerList.forEach(System.out::println);
    }
}