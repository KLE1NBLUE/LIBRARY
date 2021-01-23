package com.zane.bookadmin.controller;

import com.zane.bookadmin.pojo.Publisher;
import com.zane.bookadmin.service.IPublisherService;
import com.zane.bookadmin.util.AdminException;
import com.zane.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private IPublisherService publisherService;

    @GetMapping("/list")
    public Result list() {
        try {
            List<Publisher> list = publisherService.findAll();
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
            Publisher publisher = publisherService.findById(id);
            return new Result("查询成功", publisher);
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
            publisherService.deleteById(id);
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
    public Result saveOrUpdate(Publisher publisher) {
        try {
            if (publisher.getId() != null) {
                publisherService.updateById(publisher);
                return new Result("更新成功", null);
            }
            // 保存
            publisherService.save(publisher);
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
