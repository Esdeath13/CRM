package service;

import utils.ResultEntity;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:21
 **/
public interface UserService {
    /**
     * 管理员登录
     *
     * @param account     :账号
     * @param password：密码
     * @return ResultEntity：返回结果
     */
    ResultEntity userLogin(String account, String password);
}