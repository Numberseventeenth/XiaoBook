package com.xiao.service;

import com.xiao.domain.Borrow;

import java.util.List;

public interface IBorrowService {
    void borrow(Borrow borrow);

    void back(Integer m_id, String book_isbn);

    List<Borrow> findAll(Integer page, Integer size);
}
