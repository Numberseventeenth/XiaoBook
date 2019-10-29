package com.xiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiao.domain.Book;
import com.xiao.domain.Category;
import com.xiao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findCategory.do")
    public ModelAndView findCategory()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Category> categoryList = bookService.findCategory();
        System.out.println(categoryList);
        mv.addObject("categoryList",categoryList);
        mv.setViewName("book-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Book book)throws Exception{
        bookService.save(book);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,
            defaultValue = "1") Integer page,@RequestParam(value = "size",required = true,
            defaultValue = "4")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Book> books = bookService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(books);
        System.out.println(books);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("book-page-list");
        return mv;
    }

    /**
     * 根据isbn查询图书
     * @param isbn
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String isbn)throws Exception{
        ModelAndView mv = new ModelAndView();
        Book book = bookService.findById(isbn);
        mv.addObject("book",book);
        mv.setViewName("book-show");
        return mv;
    }

    @RequestMapping("/updateById.do")
    public ModelAndView updateById(@RequestParam(name = "id",required = true)String isbn)throws Exception{
        ModelAndView mv = new ModelAndView();
        Book book = bookService.findById(isbn);
        List<Category> categoryList = bookService.findCategory();
        mv.addObject("categoryList",categoryList);
        mv.addObject("book",book);
        mv.setViewName("book-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public ModelAndView update(Book book)throws Exception{
        System.out.println(book);
        ModelAndView mv = new ModelAndView();
        bookService.update(book);
        Book newBook = bookService.findById(book.getBook_isbn());
        mv.addObject("newBook",newBook);
        mv.setViewName("book-update");
        return mv;
    }

    @RequestMapping("/query.do")
    public ModelAndView query(@RequestParam(name = "queryId",required = true)Integer id,
                              @RequestParam(name = "queryValue",required = true)String value){
        ModelAndView mv = new ModelAndView();
        System.out.println(id);
        System.out.println(value);
        List<Book> books = bookService.query(id,value);
        mv.addObject("books",books);
        mv.setViewName("book-query-page");
        return mv;
    }

    @RequestMapping("/queryBookByNameAndIsbn.do")
    public ModelAndView queryBookByNameAndIsbn(String book){
        ModelAndView mv = new ModelAndView();
        List<Book> books = bookService.queryBookByNameAndIsbn(book);
        mv.addObject("books",books);
        mv.setViewName("book-query-list");
        return mv;
    }
}
