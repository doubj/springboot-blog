package com.guojunjie.springbootblog.service;

import com.guojunjie.springbootblog.entity.User;
import com.guojunjie.springbootblog.service.dto.UserPassDTO;


/**
 * @author guojunjie
 */
public interface UserService {


    /**
     * 根据token获取用户信息
     * @param token token
     * @return 返回用户信息
     */
    User getUser(String token);

    /**
     * 登录：验证用户名和密码，登录成功返回2小时时效的token
     * @param userName 用户名
     * @param password 密码
     * @return token
     */
    String getUserByUsernameAndPassword(String userName, String password);

    /**
     * 获取用户info
     * @return 只包含用户信息，不包含账户信息
     */
    User getUserInfo();

    /**
     * 更新用户个人信息
     * @param user
     */
    void updateUser(User user);


    /**
     * 更新密码
     * @param token
     * @param userPassDTO
     */
    void updatePass(String token, UserPassDTO userPassDTO);
}
