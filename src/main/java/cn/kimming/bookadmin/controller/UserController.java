package cn.kimming.bookadmin.controller;

import cn.kimming.bookadmin.pojo.User;
import cn.kimming.bookadmin.service.IUserService;
import cn.kimming.bookadmin.util.AdminException;
import cn.kimming.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public Result list() {
        try {
            List<User> list = userService.findAll();
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
            User user = userService.findById(id);
            return new Result("查询成功", user);
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
            userService.deleteById(id);
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
    public Result saveOrUpdate(User user) {
        try {
            if (user.getId() != null) {
                userService.updateById(user);
                return new Result("更新成功", null);
            }
            // 保存
            userService.save(user);
            return new Result("保存成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @GetMapping("/updateStatusById")
    public Result deleteById(@RequestParam Long id, @RequestParam Integer status) {
        try {
            userService.updateStatusById(id, status);
            if (status == 0) {
                return new Result("启用成功", null);
            }
            return new Result("冻结成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }
}
