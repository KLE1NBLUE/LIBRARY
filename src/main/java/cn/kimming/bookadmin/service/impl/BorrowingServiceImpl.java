package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.BookStockMapper;
import cn.kimming.bookadmin.mapper.BorrowingMapper;
import cn.kimming.bookadmin.pojo.BookStock;
import cn.kimming.bookadmin.pojo.Borrowing;
import cn.kimming.bookadmin.service.IBorrowingService;
import cn.kimming.bookadmin.util.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowingServiceImpl implements IBorrowingService {
    @Autowired
    private BorrowingMapper borrowingMapper;
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
        System.out.println(Borrowing.STATUS_BORROWING);
        System.out.println(status != Borrowing.STATUS_BORROWING);
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
}
