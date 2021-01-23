package com.zane.bookadmin.mapper;

import com.zane.bookadmin.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> findAll();

    long selectCountByCategoryId(Long categoryId);

    long selectCountByPublisherId(Long PublisherId);
}