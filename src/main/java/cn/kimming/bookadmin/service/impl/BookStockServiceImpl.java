package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.BookStockMapper;
import cn.kimming.bookadmin.pojo.BookStock;
import cn.kimming.bookadmin.service.IBookStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookStockServiceImpl implements IBookStockService {

    @Autowired
    private BookStockMapper bookStockMapper;
    @Override
    public List<BookStock> findAll() {
        return bookStockMapper.findAll();
    }

    @Override
    public void addTotalStock(Long id, Integer stock) {
        bookStockMapper.updateTotalStockById(id, stock);
    }
}
