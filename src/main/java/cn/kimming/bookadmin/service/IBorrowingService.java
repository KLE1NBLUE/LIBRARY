package cn.kimming.bookadmin.service;

import cn.kimming.bookadmin.pojo.Borrowing;

import java.util.List;
import java.util.Map;

public interface IBorrowingService {
    List<Borrowing> findAll();

    List<Borrowing> findByStatus(Integer status);

    void lostBook(Long id);

    Map<String, List> findHotBook();

    Map<String, List> mostBorrower();
}
