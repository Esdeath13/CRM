package factory;

import dao.CustomerDao;
import dao.InformationDao;
import dao.UserDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.InformationDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Information;
import entity.User;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 13:15
 **/
public class DaoFactory {
    /**
     * 获得UserDao实例
     *
     * @return UserDao实例
     */
    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }

    /**
     * 获得CustomerDao实例
     *
     * @return  UserDao实例
     */
    public static CustomerDao getCustomerDaoInstance(){
        return new CustomerDaoImpl();
    }

    /**
     * 获得InformationDao 实例
     *
     * @return InformationDao实例
     */
    public static InformationDao getInformationDaoInstance(){
        return new InformationDaoImpl();
    }
}
