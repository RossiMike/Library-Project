package com.myproject.library.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/list")
    public String listBooks(Model theModel) {

        List<Book> theBooks = bookService.getBooks();

        theModel.addAttribute("books", theBooks);

        return "books/list-books"; 
    }

    @GetMapping("/showFormforAdd")
    public String showFormforAdd(Model theModel) {

        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }
    
    @PostMapping("/add")
    public String registerNewBook(@ModelAttribute("book") Book theBook) {
        bookService.addNewBook(theBook);

        return "redirect:/books/list";
    }

    @PostMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {

        Book theBook = bookService.findById(theId);

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }
    
    @PostMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int bookId) {

        bookService.deleteBook(bookId);

        return "redirect:/books/list";
    }

    @PutMapping("update/{bookId}")
    public void updateBook(
        @PathVariable("bookId") int bookId,
        @RequestParam String theTitle, 
        @RequestParam String theAuthor, 
        @RequestParam int theCopies){

        bookService.updateBook(bookId, theTitle, theAuthor, theCopies);
            
            
    }

}
