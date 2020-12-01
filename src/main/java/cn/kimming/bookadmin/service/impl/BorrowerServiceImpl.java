package cn.kimming.bookadmin.service.impl;

import cn.kimming.bookadmin.mapper.BorrowerMapper;
import cn.kimming.bookadmin.pojo.Borrower;
import cn.kimming.bookadmin.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BorrowerServiceImpl implements IBorrowerService {
    @Autowired
    private BorrowerMapper borrowerMapper;

    @Override
    public List<Borrower> findAll() {
        return borrowerMapper.findAll();
    }

    @Override
    public void updateStatusById(Long id, Integer status) {
        borrowerMapper.updateStatusById(id, status);
    }

    @Override
    public List<Long> findNewReaderBeforeDate(List<String> dates) {
        List<Long> counts = new ArrayList<>();
        for (String date : dates) {
            long count = borrowerMapper.findCountBeforeDate(date);
            counts.add(count);
        }
        return counts;
    }
}
