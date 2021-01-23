package com.zane.bookadmin.service.impl;

import com.zane.bookadmin.mapper.BookStockMapper;
import com.zane.bookadmin.mapper.BorrowerMapper;
import com.zane.bookadmin.mapper.BorrowingMapper;
import com.zane.bookadmin.pojo.BookStock;
import com.zane.bookadmin.pojo.Borrowing;
import com.zane.bookadmin.service.IBorrowingService;
import com.zane.bookadmin.util.AdminException;
import com.zane.bookadmin.util.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BorrowingServiceImpl implements IBorrowingService {
    @Autowired
    private BorrowingMapper borrowingMapper;
    @Autowired
    private BorrowerMapper borrowerMapper;
    @Autowired
    private BookStockMapper bookStockMapper;
    @Override
    public List<Borrowing> findAll() {
        return borrowingMapper.findAll();
    }

    @Override
    public List<Borrowing> findByStatus(Integer status) {
        return borrowingMapper.findByStatus(status);
    }

    @Override
    public void lostBook(Long id) {
        Borrowing borrowing = borrowingMapper.selectByPrimaryKey(id);
        // 检查借阅状态
        Short status = borrowing.getStatus();
        if (status != Borrowing.STATUS_BORROWING && status != Borrowing.STATUS_OVERTIME_BORROWING) {
            throw new AdminException("操作失败, 该记录不在借阅状态中, 无法报失");
        }
        // 检查总库存
        BookStock bs = bookStockMapper.selectByBookId(borrowing.getBookId());
        if (bs.getTotalStock() <= 0) {
            throw new AdminException("操作失败, 此书籍总库存已经为零, 请与库存管理员核对信息");
        }

        // 修改借阅状态
        borrowing.setStatus(Borrowing.STATUS_LOST);
        borrowingMapper.updateByPrimaryKeySelective(borrowing);
        // 修改总库存 -1
        bs.setTotalStock(bs.getTotalStock() - 1);
        bookStockMapper.updateByPrimaryKeySelective(bs);
    }

    @Override
    public Map<String, List> findHotBook() {
        Map<String, List> map = new HashMap<>();
        List<Map<String, Object>> hotBooks = borrowingMapper.findHotBook();
        List<Object> bookNames = new ArrayList<>();
        for (Map<String, Object> hotBook : hotBooks) {
            bookNames.add(hotBook.get("name"));
        }
        map.put("bookNames", bookNames);
        map.put("bookDatas", hotBooks);
        return map;
    }

    @Override
    public Map<String, List> mostBorrower() {
        Map<String, List> result = new HashMap<>();
        String firstDay = MyDateUtil.getCurrentMonthFirstDay();
        List<Map<String, Object>> map = borrowingMapper.findBorrowCountAfterDate(firstDay);

        List<Object> borrowerNames = new ArrayList<>();
        List<Object> borrowCounts = new ArrayList<>();
        for (Map<String, Object> obj : map) {
            borrowerNames.add(obj.get("borrowerName"));
            borrowCounts.add(obj.get("borrowCount"));
        }
        result.put("borrowerNames", borrowerNames);
        result.put("borrowCounts", borrowCounts);
        return result;
    }
}