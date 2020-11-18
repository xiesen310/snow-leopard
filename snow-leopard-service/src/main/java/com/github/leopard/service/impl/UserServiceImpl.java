package com.github.leopard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.leopard.dao.UserMapper;
import com.github.leopard.dao.model.User;
import com.github.leopard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢森
 * @Description UserServiceImpl
 * @Email xiesen310@163.com
 * @Date 2020/11/18 18:48
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public boolean saveUser(User user) {
        int row = userMapper.insert(user);
        return row > 0;
    }

    @Override
    public boolean updateUser(User user) {
        Long id = user.getId();
        User user1 = userMapper.selectById(id);

        int row = userMapper.updateById(user);
        return row > 0;
    }

    @Override
    public User findUser(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        int i = userMapper.deleteById(id);
        return i > 0;
    }
}
