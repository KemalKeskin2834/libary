package com.kemalkeskin.library.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "publisher_name", unique = true)
    private String publisherName;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;

    public Publisher() {
    }

    public Publisher(int id, String publisherName,List<Book>bookList) {
        this.id = id;
        this.publisherName = publisherName;
        this.bookList=bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
