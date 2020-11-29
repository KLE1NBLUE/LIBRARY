package cn.kimming.bookadmin.mapper;

import cn.kimming.bookadmin.pojo.Borrowing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
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
}