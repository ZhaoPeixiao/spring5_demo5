package com.peixiao.spring5.dao;

import com.peixiao.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Peixiao Zhao
 * @date 2020/9/16 17:00
 */
@Repository
public class BookDaoImpl implements BookDao{

    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加
    @Override
    public void add(Book book) {
        // 创建sql语句
        String sql = "insert into t_user values(?,?,?)";
        // 调用方法实现
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    // 修改
    @Override
    public void update(Book book) {
        // 创建sql语句
        String sql = "update t_user set username=?, ustatus=? where user_id=?";
        Object[] args = {book.getUsername(), book.getUstatus(), book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    // 删除
    @Override
    public void delete(int id) {
        // 创建sql语句
        String sql = "delete from t_user where user_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    // 查询表中记录数
    @Override
    public int seleceCount() {
        // 创建sql语句
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(int id) {
        // 创建sql语句
        String sql = "select * from t_user where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook(String uStatus) {
        // 创建sql语句
        String sql = "select * from t_user where ustatus=?";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), uStatus);
        return books;
    }

    @Override
    public void batchAddBook(List<Object[]> books) {
        // 创建sql语句
        String sql = "insert into t_user values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> books) {
        // 创建sql语句
        String sql = "update t_user set username=?, ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> books) {
        // 创建sql语句
        String sql = "delete from t_user where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(ints));
    }
}
