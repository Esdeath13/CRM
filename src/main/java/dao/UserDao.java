package dao;

import entity.User;

import java.sql.SQLException;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:33
 **/
public interface UserDao {
    /**
     * 根据账号查找管理员
     *
     * @param account:账号入参
     * @return Admin：管理员信息
     * @throws SQLException： 该方法会抛出SQL异常
     */
    User findUserByAccount(String account) throws SQLException;
}