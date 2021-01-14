package service.impl;

import dao.UserDao;
import entity.User;
import factory.DaoFactory;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;
import utils.ResultEntity;

import java.sql.SQLException;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:31
 **/
public class UserServiceImpl implements UserService {
    private final UserDao userDao = DaoFactory.getUserDaoInstance();

    @Override
    public ResultEntity userLogin(String account, String password) {
        ResultEntity resultEntity;
        User user = null;
        try {
            //根据账号查找管理员信息，捕获SQL异常
            user = userDao.findUserByAccount(account);
        } catch (SQLException e) {
            System.err.println("根据账号查找管理员信息出现SQL异常");
        }
        //根据账号查找到了记录
        if (user != null) {


            if (password.equals(user.getPassword())) {
                resultEntity = ResultEntity.builder().code(0).message("登录成功").data(user).type(user.getType()).build();
            } else {
                resultEntity = ResultEntity.builder().code(1).message("密码错误").build();
            }
        } else {
            //账号不存在
            resultEntity = ResultEntity.builder().code(2).message("账号不存在").build();
        }
        return resultEntity;
    }
}
