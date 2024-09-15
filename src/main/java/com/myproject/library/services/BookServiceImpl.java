package com.myproject.library.services;

import org.springframework.stereotype.Service;

import com.myproject.library.entities.Book;
import com.myproject.library.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository theBookRepository){
        bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAllByOrderByTitleAsc();
    }



    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);

        Book theBook = null;

        if (result.isPresent()){
            theBook = result.get();
        }
        else {
            throw new RuntimeException("No such id");
        }
        
        return theBook;
    }   



    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }



    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

    // public Book findById(int bookId) {
    //     Optional<Book> result = bookRepository.findById(bookId);

    //     Book theBook = null;

    //     if (result.isPresent()) {
    //         theBook = result.get();
    //     }
    //     else {
    //         throw new RuntimeException("Did not find book id - " + bookId);
    //     }

    //     return theBook;
    // }

    // public List<Book> getBooks() {
    //     return bookRepository.findAllByOrderByTitleAsc();
    // }

    // public void addNewBook(Book theBook) {
    //     Optional<Book> bookTitle = bookRepository.findByTitle(theBook.getTitle());
    //     if (bookTitle.isPresent()) {
    //         throw new IllegalStateException("Book already in database");
    //     }
    //     bookRepository.save(theBook);
    // }

    // public void deleteBook(int theId) {
    //     boolean exists = bookRepository.existsById(theId);
    //     if (!exists) {
    //         throw new IllegalStateException("Book with id " + theId + " does not exists.");
    //     }
    //     bookRepository.deleteById(theId);

    // }

    // @Transactional
    // public void updateBook(int bookId, String theTitle, String theAuthor, int theCopies) {
    //     Optional<Book> checkBook = bookRepository.findById(bookId);

    //     if (!checkBook.isPresent()) {
    //         throw new IllegalTransactionStateException("Not found");
    //     }

    //     Book theBook = findById(bookId);

    //     theBook.setTitle(theTitle);
    //     theBook.setAuthor(theAuthor);
    //     theBook.setCopies(theCopies);

    //     bookRepository.save(theBook);
    // }

}
