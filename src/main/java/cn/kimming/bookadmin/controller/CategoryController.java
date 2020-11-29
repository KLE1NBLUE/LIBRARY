package cn.kimming.bookadmin.controller;

import cn.kimming.bookadmin.pojo.Category;
import cn.kimming.bookadmin.service.ICategoryService;
import cn.kimming.bookadmin.util.AdminException;
import cn.kimming.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public Result list() {
        try {
            List<Category> list = categoryService.findAll();
            return new Result("查询成功", list);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @GetMapping("/findById")
    public Result findById(@RequestParam Long id) {
        try {
            Category category = categoryService.findById(id);
            return new Result("查询成功", category);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }

    }

    @GetMapping("/deleteById")
    public Result deleteById(@RequestParam Long id) {
        try {
            categoryService.deleteById(id);
            return new Result("删除成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(Category category) {
        try {
            if (category.getId() != null) {
                categoryService.updateById(category);
                return new Result("更新成功", null);
            }
            // 保存
            categoryService.save(category);
            return new Result("保存成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }
}
