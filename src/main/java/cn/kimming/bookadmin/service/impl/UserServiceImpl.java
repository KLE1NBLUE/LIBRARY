package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.UserMapper;
import cn.kimming.bookadmin.pojo.User;
import cn.kimming.bookadmin.service.IUserService;
import cn.kimming.bookadmin.util.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(User user) {
        // 检查用户名是否存在
        User dbUser = userMapper.findByUsername(user.getUsername());
        if (dbUser != null) {
            throw new AdminException("保存失败, 该用户名已经存在");
        }
        // 设置初始密码
        user.setPassword(encoder.encode("123456"));
        // 设置用户启动状态
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

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) {
        User user = userMapper.findByUsername(username);
        if (!encoder.matches(oldPassword, user.getPassword())) {
            throw new AdminException("修改失败, 旧密码错误");
        }
        user.setPassword(encoder.encode(newPassword));
        userMapper.updateByPrimaryKeySelective(user);
    }
}
