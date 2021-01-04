package factory;

import entity.Information;
import service.CustomerService;
import service.InformationService;
import service.UserService;
import service.impl.CustomerServiceImpl;
import service.impl.InformationServiceImpl;
import service.impl.UserServiceImpl;

/**
 * @ClassName ServiceFactory
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 11:26
 **/
public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }


    public static CustomerService getCustomerSeriviceInstance(){
        return new CustomerServiceImpl();
    }

    public static InformationService getInformationServiceInstance(){
        return new InformationServiceImpl();
    }
}
