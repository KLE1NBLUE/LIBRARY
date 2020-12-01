package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.*;
import cn.kimming.bookadmin.pojo.Book;
import cn.kimming.bookadmin.pojo.BookStock;
import cn.kimming.bookadmin.pojo.Category;
import cn.kimming.bookadmin.pojo.Publisher;
import cn.kimming.bookadmin.service.IBookService;
import cn.kimming.bookadmin.util.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private PublisherMapper publisherMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BookStockMapper bookStockMapper;
    @Autowired
    private BorrowingMapper borrowingMapper;
    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public void save(Book book) {
        Category category = categoryMapper.selectByPrimaryKey(book.getCategoryId());
        if (category == null) {
            throw new AdminException("保存失败, 此分类记录");
        }
        Publisher publisher = publisherMapper.selectByPrimaryKey(book.getPublisherId());
        if (publisher == null) {
            throw new AdminException("保存失败, 此出版社记录");
        }
        bookMapper.insertSelective(book);
        // 生成该书籍的图书代码
        String code = category.getCode() + book.getId();
        book.setCode(code);
        bookMapper.updateByPrimaryKeySelective(book);
        // 添加库存记录
        BookStock bs = new BookStock(book.getId());
        bookStockMapper.insertSelective(bs);
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void deleteById(Long id) {
        // 检查书本是否被借阅中
        long count = borrowingMapper.findBorrowingCountByBookId(id);
        if (count > 0){
            throw new AdminException("删除失败, 该书籍存在借阅中记录");
        }
        // 删除库存信息
        bookStockMapper.deleteByBookId(id);
        bookMapper.deleteByPrimaryKey(id);
    }
}
