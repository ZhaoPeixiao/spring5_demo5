package com.peixiao.spring5.service;

import com.peixiao.spring5.dao.BookDao;
import com.peixiao.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

/**
 * @author Peixiao Zhao
 * @date 2020/9/16 17:00
 */
@Service
public class BookService {
    // 注入Dao
    @Autowired
    private BookDao bookDao;

    // 添加
    public void addBook(Book book){
        bookDao.add(book);
    }

    // 批量添加
    public void batchAdd(List<Object[]> books){
        bookDao.batchAddBook(books);
    }

    // 修改
    public void update(Book book){
        bookDao.update(book);
    }

    // 批量修改
    public void batchUpdate(List<Object[]> books){
        bookDao.batchUpdateBook(books);
    }


    // 删除
    public void delete(int id){
        bookDao.delete(id);
    }

    // 批量删除
    public void batchDelete(List<Object[]> books){
        bookDao.batchDeleteBook(books);
    }

    // 查询表中记录数
    public int findCount(){
        return bookDao.seleceCount();
    }

    // 查询返回对象
    public Book findOne(int id){
        return bookDao.findBookInfo(id);
    }

    // 查询返回集合
    public List<Book> findAll(String uStatus){
        return bookDao.findAllBook(uStatus);
    }



}
