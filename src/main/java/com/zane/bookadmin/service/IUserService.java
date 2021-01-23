package com.zane.bookadmin.service;

import com.zane.bookadmin.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);

    void updateById(User user);

    void save(User user);

    void updateStatusById(Long id, Integer status);

    void updatePassword(String username, String oldPassword, String newPassword);
}
