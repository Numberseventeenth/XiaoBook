package com.xiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiao.dao.IBookDao;
import com.xiao.dao.IBorrowDao;
import com.xiao.domain.Borrow;
import com.xiao.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowServiceImpl implements IBorrowService {

    @Autowired
    private IBorrowDao borrowDao;


    @Override
    public void borrow(Borrow borrow) {

        borrowDao.borrow(borrow);

    }

    @Override
    public void back(Integer m_id, String book_isbn) {
        borrowDao.back(m_id,book_isbn);
    }

    @Override
    public List<Borrow> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return borrowDao.findAll();
    }
}
