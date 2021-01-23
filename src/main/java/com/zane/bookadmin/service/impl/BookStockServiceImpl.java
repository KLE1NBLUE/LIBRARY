package com.zane.bookadmin.service.impl;

import com.zane.bookadmin.mapper.BookStockMapper;
import com.zane.bookadmin.pojo.BookStock;
import com.zane.bookadmin.service.IBookStockService;
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
