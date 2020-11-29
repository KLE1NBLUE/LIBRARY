package cn.kimming.bookadmin.service;

import cn.kimming.bookadmin.pojo.Borrower;

import java.util.List;

public interface IBorrowerService {
    List<Borrower> findAll();

    void updateStatusById(Long id, Integer status);
}
