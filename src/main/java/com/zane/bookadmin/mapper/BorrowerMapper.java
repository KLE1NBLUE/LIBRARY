package com.zane.bookadmin.mapper;

import com.zane.bookadmin.pojo.Borrower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BorrowerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Borrower record);

    int insertSelective(Borrower record);

    Borrower selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Borrower record);

    int updateByPrimaryKey(Borrower record);

    List<Borrower> findAll();

    void updateStatusById(@Param("id") Long id, @Param("status")Integer status);

    long findCountBeforeDate(String date);
}