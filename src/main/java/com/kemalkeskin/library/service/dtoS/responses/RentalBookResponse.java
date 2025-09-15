
package com.kemalkeskin.library.service.dtoS.responses;

import java.time.LocalDate;

public class RentalBookResponse {

    private int id;

    private String bookName;

    private LocalDate rentedDate;

    private  LocalDate returnDate;

    private String firstName;

    private String lastName;

    public RentalBookResponse() {
    }

    public RentalBookResponse(int id, String bookName,LocalDate rentedDate,LocalDate returnDate,String firstName,String lastName) {
        this.id = id;
        this.bookName = bookName;
        this.rentedDate=rentedDate;
        this.returnDate=returnDate;
        this.firstName=firstName;
        this.lastName=lastName;
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

