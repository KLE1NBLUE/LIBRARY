package cn.kimming.bookadmin.service;

import cn.kimming.bookadmin.pojo.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Long id);

    void updateById(Category category);

    void deleteById(Long id);
}
