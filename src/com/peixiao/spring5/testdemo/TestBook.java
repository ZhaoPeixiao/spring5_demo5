package com.peixiao.spring5.testdemo;

import com.peixiao.spring5.entity.Book;
import com.peixiao.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Peixiao Zhao
 * @date 2020/9/16 17:21
 */
public class TestBook {

    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId(1);
        book.setUsername("java");
        book.setUstatus("good");
        bookService.addBook(book);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId(2);
        book.setUsername("python");
        book.setUstatus("not bad");
        bookService.update(book);
    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.delete(2);
    }

    @Test
    public void testFindCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findCount());
    }

    @Test
    public void testFindBok(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findOne(2));
    }

    @Test
    public void testFindAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findAll("great"));
    }

    @Test
    public void testBatchAdd(){
        List<Object[]> books = new ArrayList<>();
        Object[] o1 = {6, "julia", "bad"};
        Object[] o2 = {7, "golang", "good"};
        Object[] o3 = {8, "PHP", "best"};
        books.add(o1);
        books.add(o2);
        books.add(o3);
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.batchAdd(books);
    }

    @Test
    public void testBatchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> books = new ArrayList<>();
        Object[] o1 = {"julia", "normal", 6};
        Object[] o2 = {"golang", "great", 7};
        books.add(o1);
        books.add(o2);
        bookService.batchUpdate(books);
    }

    @Test
    public void testBatchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> books = new ArrayList<>();
        Object[] o1 = {6};
        Object[] o2 = {9};
        books.add(o1);
        books.add(o2);
        bookService.batchDelete(books);
    }
}
