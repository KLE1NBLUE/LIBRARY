package cn.kimming.bookadmin.controller;

import cn.kimming.bookadmin.pojo.Book;
import cn.kimming.bookadmin.service.IBookService;
import cn.kimming.bookadmin.util.AdminException;
import cn.kimming.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;


    @GetMapping("/list")
    public Result list() {
        try {
            List<Book> list = bookService.findAll();
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
            Book book = bookService.findById(id);
            return new Result("查询成功", book);
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
            bookService.deleteById(id);
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
    public Result saveOrUpdate(Book book) {
        try {
            if (book.getId() != null) {
                bookService.updateById(book);
                return new Result("更新成功", null);
            }
            // 保存
            bookService.save(book);
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
