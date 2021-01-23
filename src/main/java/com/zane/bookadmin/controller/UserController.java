package com.zane.bookadmin.controller;

import com.zane.bookadmin.pojo.User;
import com.zane.bookadmin.service.IUserService;
import com.zane.bookadmin.util.AdminException;
import com.zane.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/current")
    public Map<String, Object> currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", userDetails.getUsername());
        map.put("authorities", userDetails.getAuthorities());
        return map;
    }

    @PostMapping("/updatePassword")
    public Result updatePassword(String username, String oldPassword, String newPassword) {
        try {
            userService.updatePassword(username, oldPassword, newPassword);
            return new Result("修改密码成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }
}
