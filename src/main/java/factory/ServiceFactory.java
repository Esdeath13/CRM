package factory;

import service.UserService;
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
}
