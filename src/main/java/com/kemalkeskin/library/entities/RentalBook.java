package com.kemalkeskin.library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rentedbooks")
public class RentalBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "rented_date")
    private LocalDate rentedDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public RentalBook() {
    }

    public RentalBook(int id, Book book, LocalDate rentedDate, LocalDate returnDate, String firstName, String lastName) {
        this.id = id;
        this.book = book;
        this.rentedDate = rentedDate;
        this.returnDate = returnDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(LocalDate rentedDate) {
        this.rentedDate = rentedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
