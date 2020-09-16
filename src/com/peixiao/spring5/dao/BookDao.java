package com.peixiao.spring5.dao;

import com.peixiao.spring5.entity.Book;

import java.util.List;

/**
 * @author Peixiao Zhao
 * @date 2020/9/16 17:00
 */
public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(int id);

    int seleceCount();

    Book findBookInfo(int id);

    List<Book> findAllBook(String uStatus);

    void batchAddBook(List<Object[]> books);

    void batchUpdateBook(List<Object[]> books);

    void batchDeleteBook(List<Object[]> books);

}
