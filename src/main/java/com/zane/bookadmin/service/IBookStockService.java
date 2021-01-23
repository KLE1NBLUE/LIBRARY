package com.zane.bookadmin.service;

import com.zane.bookadmin.pojo.BookStock;

import java.util.List;

public interface IBookStockService {
    List<BookStock> findAll();

    void addTotalStock(Long id, Integer stock);
}
