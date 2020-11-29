package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.PublisherMapper;
import cn.kimming.bookadmin.pojo.Publisher;
import cn.kimming.bookadmin.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherServiceImpl implements IPublisherService {
    @Autowired
    private PublisherMapper publisherMapper;
    @Override
    public List<Publisher> findAll() {
        return publisherMapper.findAll();
    }

    @Override
    public void save(Publisher publisher) {
        publisherMapper.insertSelective(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Publisher publisher) {
        publisherMapper.updateByPrimaryKeySelective(publisher);
    }
    @Override
    public void deleteById(Long id) {
        publisherMapper.deleteByPrimaryKey(id);
    }
}
