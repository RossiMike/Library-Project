package com.myproject.library.Book;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getBooks();
          
    }
    
    @PostMapping("/add")
    public void registerNewBook(@RequestBody Book theBook) {
        bookService.addNewBook(theBook);
    }
    
    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId) {

        bookService.deleteBook(bookId);

    }

    @PutMapping("update/{bookId}")
    public void updateBook(
        @PathVariable("bookId") Integer bookId,
        @RequestParam String theTitle, 
        @RequestParam String theAuthor, 
        @RequestParam Integer theCopies){

        bookService.updateBook(bookId, theTitle, theAuthor, theCopies);
            
            
    }

}
