package com.github.leopard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.leopard.dao.model.User;

import java.util.List;

/**
 * @author 谢森
 * @Description 用户服务
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:40
 */
public interface UserService extends IService<User> {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    boolean saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据 id 查询用户
     *
     * @param id
     * @return
     */
    User findUser(Long id);

    /**
     * 根据 id 删除用户
     *
     * @param id
     * @return
     */
    boolean deleteUser(Long id);
}
