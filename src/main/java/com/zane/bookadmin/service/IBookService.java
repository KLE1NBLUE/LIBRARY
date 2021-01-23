package com.zane.bookadmin.service;

import com.zane.bookadmin.pojo.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);

    void deleteById(Long id);

    void updateById(Book book);

    void save(Book book);
}
