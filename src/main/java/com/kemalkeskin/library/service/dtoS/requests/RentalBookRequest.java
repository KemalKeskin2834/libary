
package com.kemalkeskin.library.service.dtoS.requests;

import com.kemalkeskin.library.core.utility.StringNormalizer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RentalBookRequest {

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "Book ID cannot be null")
    private int bookId;

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "Book ID cannot be null")
    @Size(min = 3,message = "author name is minimum length 3 characters")
    private String firstName;

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "Book ID cannot be null")
    @Size(min = 3,message = "author name is minimum length 3 characters")
    private String lastName;

    public RentalBookRequest() {
    }

    public RentalBookRequest(int bookId, String firstName, String lastName) {
        this.bookId = bookId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = StringNormalizer.normalize(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = StringNormalizer.normalize(lastName);;
    }
}
