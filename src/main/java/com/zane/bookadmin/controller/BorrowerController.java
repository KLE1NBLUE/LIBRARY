package com.zane.bookadmin.controller;

import com.zane.bookadmin.pojo.Borrower;
import com.zane.bookadmin.service.IBorrowerService;
import com.zane.bookadmin.util.AdminException;
import com.zane.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {
    @Autowired
    private IBorrowerService borrowerService;


    @GetMapping("/list")
    public Result list() {
        try {
            List<Borrower> list = borrowerService.findAll();
            return new Result("查询成功", list);
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
            borrowerService.updateStatusById(id, status);
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
