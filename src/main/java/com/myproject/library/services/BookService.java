package com.myproject.library.services;

import java.util.List;

import com.myproject.library.entities.Book;

public interface BookService  {

    List<Book> findAll();

    Book findById(int theId);

    void save(Book theBook);

    void deleteById(int theId);
}
