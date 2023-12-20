package com.itheima.controller;

import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller + @ResponseBody
@RequestMapping("/books")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @GetMapping
    public Result getBookAll() {
        List<Book> books = bookService.getBookAll();
        Result result = new Result(null, books, null);
        if (books == null) {
            result.setCode(Code.GET_ERR);
            result.setMsg("没有查询到!");
        }else{
            result.setCode(Code.GET_OK);
            result.setMsg(null);
        }
        return result;
    }

    @GetMapping("/{id}")
    public Result getBookById(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        Result result = new Result(null, book, null);
        if (book == null) {
            result.setCode(Code.GET_ERR);
            result.setMsg("没有查询到!");
        }else{
            result.setCode(Code.GET_OK);
            result.setMsg(null);
        }
        int i = 1/0;
        return result;
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, null);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, null);
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);

        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, null);
    }
}
/**
 * Rest 风格开发
 * 业务层接口(junit)和表现层接口(postman)开发完后都要进行测试
 */
