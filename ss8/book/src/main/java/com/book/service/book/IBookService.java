package com.book.service.book;

import com.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findBookById(int id);
    void save(Book book);
}
