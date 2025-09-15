package com.kemalkeskin.library.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name",unique = true)
    private String authorName;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author() {
    }

    public Author(int id, String authorName,List<Book>bookList) {
        this.id = id;
        this.authorName = authorName;
        this.bookList=bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
