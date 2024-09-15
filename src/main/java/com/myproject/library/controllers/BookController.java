package com.myproject.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.library.entities.Book;
import com.myproject.library.services.BookServiceImpl;



@Controller
@RequestMapping("/books")
public class BookController {

    public final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/list")
    public String listBooks(Model theModel) {

        List<Book> theBooks = bookService.findAll();

        theModel.addAttribute("books", theBooks);

        return "/books/list-books"; 
    }

    @GetMapping("/showFormforAdd")
    public String showFormforAdd(Model theModel) {

        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }
    
    @PostMapping("/save")
    public String registerNewBook(@ModelAttribute("book") Book theBook) {
        
        bookService.save(theBook);

        return "redirect:/books/list";
    }

    @PostMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {

        Book theBook = bookService.findById(theId);

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }
    
    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int bookId) {

        bookService.deleteById(bookId);

        return "redirect:/books/list";
    }


}
