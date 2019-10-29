package com.xiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiao.dao.IBookDao;
import com.xiao.domain.Book;
import com.xiao.domain.Category;
import com.xiao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Category> findCategory() {
        List<Category> categoryList = bookDao.findCategory();
        return categoryList;
    }

    @Override
    public void save(Book book) {
        Date date = new Date();
        book.setBook_date(date);
        bookDao.save(book);
    }

    @Override
    public List<Book> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return bookDao.findAll();
    }

    @Override
    public Book findById(String id) {
        Book book = bookDao.findById(id);
        return book;
    }

    @Override
    public void update(Book book) {
         bookDao.update(book);
    }

    @Override
    public List<Book> query(Integer id, String value) {
        /*<option value="0">年份</option>
        <option value="1">出版社</option>
        <option value="2">作者</option>
        <option value="3">书名</option>
        <option value="4">模糊</option>
        <option value="5">类别</option>*/
        List<Book> books = null;
        if(id == 0){
            books = bookDao.queryByYear( "%"+value+"%");
        }else if(id == 1){
            books = bookDao.queryByPublic("%"+value+"%");
        }else if(id == 2){
            books = bookDao.queryByAuthor("%"+value+"%");
        }else if(id == 3){
            books = bookDao.queryByName("%"+value+"%");
        }else if(id == 4){
            books = bookDao.queryByVague("%"+value+"%");
        }else if(id == 5){
            books = bookDao.queryByCategory("%"+value+"%");
        }
        return books;
    }

    @Override
    public List<Book> queryBookByNameAndIsbn(String book) {
        return bookDao.queryBookByNameAndIsbn(book);
    }

    @Override
    public void updateBorrow(String book_isbn) {
        bookDao.updateBorrow(book_isbn);
    }

    @Override
    public void updateBack(String book_isbn) {
        bookDao.updateBack(book_isbn);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
