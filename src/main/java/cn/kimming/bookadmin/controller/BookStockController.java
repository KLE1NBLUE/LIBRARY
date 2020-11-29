package cn.kimming.bookadmin.controller;

import cn.kimming.bookadmin.pojo.BookStock;
import cn.kimming.bookadmin.service.IBookStockService;
import cn.kimming.bookadmin.util.AdminException;
import cn.kimming.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookstock")
public class BookStockController {
    @Autowired
    private IBookStockService bookStockService;

    @GetMapping("/list")
    public Result list() {
        try {
            List<BookStock> list = bookStockService.findAll();
            return new Result("查询成功", list);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @GetMapping("/addStock")
    public Result addStock(@RequestParam Long id, @RequestParam Integer stock) {
        try {
            bookStockService.addTotalStock(id, stock);
            return new Result("添加库存成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }
}
