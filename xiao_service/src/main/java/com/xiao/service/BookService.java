package com.xiao.service;

import com.xiao.domain.Book;
import com.xiao.domain.Category;

import java.util.List;

public interface BookService {
    List<Category> findCategory();

    void save(Book book);

    List<Book> findAll(Integer page, Integer size);

    Book findById(String id);

    void update(Book book);

    List<Book> query(Integer id, String value);

    List<Book> queryBookByNameAndIsbn(String book);

    void updateBorrow(String book_isbn);

    void updateBack(String book_isbn);

    List<Book> findAll();
}
