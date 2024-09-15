package com.myproject.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllByOrderByTitleAsc();

}
