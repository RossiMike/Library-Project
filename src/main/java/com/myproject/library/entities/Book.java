package com.myproject.library.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {

    // fields 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="copies")
    private int copies;

    // constructor

    public Book() {

    }

    public Book(int id, String title, String author, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    
    // methods

    @Override
    public String toString() {
        return "Title: " + title + " Author: " +  author;
    }

}
