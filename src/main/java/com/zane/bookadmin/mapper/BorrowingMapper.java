package com.zane.bookadmin.mapper;

import com.zane.bookadmin.pojo.Borrowing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BorrowingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Borrowing record);

    int insertSelective(Borrowing record);

    Borrowing selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Borrowing record);

    int updateByPrimaryKey(Borrowing record);

    List<Borrowing> findAll();

    List<Borrowing> findByStatus(Integer status);

    long findBorrowingCountByBookId(Long bookId);

    List<Map<String, Object>> findHotBook();

    List<Map<String, Object>> findBorrowCountAfterDate(String firstDay);
}