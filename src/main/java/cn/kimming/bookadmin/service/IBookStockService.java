package cn.kimming.bookadmin.service;

import cn.kimming.bookadmin.pojo.BookStock;

import java.util.List;

public interface IBookStockService {
    List<BookStock> findAll();

    void addTotalStock(Long id, Integer stock);
}
