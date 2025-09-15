package com.kemalkeskin.library.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "page_numbers")
    private int pageNumbers;


    private Boolean status;  //false=> rentable // true=>// untenantable

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY )
    private List<RentalBook> rentalBooks;

    public Book() {
    }

    public Book(int id, String bookName, int pageNumbers, Author author, Publisher publisher,List<RentalBook>rentalBooks,boolean status) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.author = author;
        this.publisher = publisher;
        this.rentalBooks=rentalBooks;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<RentalBook> getRentalBooks() {
        return rentalBooks;
    }

    public void setRentalBooks(List<RentalBook> rentalBooks) {
        this.rentalBooks = rentalBooks;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
