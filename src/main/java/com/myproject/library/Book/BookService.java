package com.myproject.library.Book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Integer bookId) {
        Optional<Book> result = bookRepository.findById(bookId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            throw new RuntimeException("Did not find book id - " + bookId);
        }

        return theBook;
    }

    public List<Book> getBooks() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    public void addNewBook(Book theBook) {
        Optional<Book> bookTitle = bookRepository.findByTitle(theBook.getTitle());
        if (bookTitle.isPresent()) {
            throw new IllegalStateException("Book already in database");
        }
        bookRepository.save(theBook);
    }

    public void deleteBook(Integer theId) {
        boolean exists = bookRepository.existsById(theId);
        if (!exists) {
            throw new IllegalStateException("Book with id " + theId + " does not exists.");
        }
        bookRepository.deleteById(theId);

    }

    @Transactional
    public void updateBook(Integer bookId, String theTitle, String theAuthor, Integer theCopies) {
        Optional<Book> checkBook = bookRepository.findById(bookId);

        if (!checkBook.isPresent()) {
            throw new IllegalTransactionStateException("Not found");
        }

        Book theBook = findById(bookId);

        theBook.setTitle(theTitle);
        theBook.setAuthor(theAuthor);
        theBook.setCopies(theCopies);

        bookRepository.save(theBook);
    }

}
