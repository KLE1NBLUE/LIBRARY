package cn.kimming.bookadmin.controller;

import cn.kimming.bookadmin.service.IBorrowerService;
import cn.kimming.bookadmin.service.IBorrowingService;
import cn.kimming.bookadmin.util.AdminException;
import cn.kimming.bookadmin.util.MyDateUtil;
import cn.kimming.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private IBorrowingService borrowingService;
    @Autowired
    private IBorrowerService borrowerService;

    @GetMapping("/hotBook")
    public Result hotBook() {
        try {
            Map<String, List> map = borrowingService.findHotBook();
            return new Result("查询成功", map);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }
    @GetMapping("/newReader")
    public Result newReader() {
        try {
            Map<String, List> map = new HashMap<>();
            List<String> months = MyDateUtil.getRecent3MonthsLastDay();
            List<Long> counts = borrowerService.findNewReaderBeforeDate(months);
            map.put("months", months);
            map.put("counts", counts);
            return new Result("查询成功", map);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @GetMapping("/mostBorrower")
    public Result mostBorrower() {
        try {
            Map<String, List> map = borrowingService.mostBorrower();
            return new Result("查询成功", map);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

}
