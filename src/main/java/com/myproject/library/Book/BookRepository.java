package com.myproject.library.Book;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllByOrderByTitleAsc();

    Optional<Book> findByTitle(String theTitle);

}
