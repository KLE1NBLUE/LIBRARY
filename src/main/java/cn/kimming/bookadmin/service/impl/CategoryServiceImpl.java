package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.CategoryMapper;
import cn.kimming.bookadmin.pojo.Category;
import cn.kimming.bookadmin.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public void save(Category category) {
        categoryMapper.insertSelective(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
    @Override
    public void deleteById(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
