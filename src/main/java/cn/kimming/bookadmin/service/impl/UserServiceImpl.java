package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.UserMapper;
import cn.kimming.bookadmin.pojo.User;
import cn.kimming.bookadmin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(User user) {
        user.setStatus(User.STATUS_ENABLED);
        userMapper.insertSelective(user);
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
    @Override
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateStatusById(Long id, Integer status) {
        userMapper.updateStatusById(id, status);
    }
}
