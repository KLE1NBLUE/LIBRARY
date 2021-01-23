package com.zane.bookadmin.mapper;

import com.zane.bookadmin.pojo.BookStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookStock record);

    int insertSelective(BookStock record);

    BookStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookStock record);

    int updateByPrimaryKey(BookStock record);

    List<BookStock> findAll();

    void updateTotalStockById(@Param("id") Long id,@Param("stock") Integer stock);

    BookStock selectByBookId(Long bookId);

    void deleteByBookId(Long bookId);
}