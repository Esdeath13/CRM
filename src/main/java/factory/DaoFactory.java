package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 13:15
 **/
public class DaoFactory {
    /**
     * 获得AdminDao实例
     *
     * @return AdminDao实例
     */
    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }


}
