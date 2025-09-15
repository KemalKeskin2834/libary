
package com.kemalkeskin.library.service.dtoS.requests;

import com.kemalkeskin.library.core.utility.StringNormalizer;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Locale;

public class BookRequest {


    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    @Size(min = 3,message = "author name is minimum length 3 characters")
    private String bookName;


    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    @Min(value = 10,message = "page numbers minumum number 10")
    private int pageNumbers;


    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    private boolean status;

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    private int authorId;

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    private int publisherId;

    public BookRequest() {
    }

    public BookRequest(String bookName, int pageNumbers, int authorId, int publisherId,boolean status) {
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.status=status;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = StringNormalizer.normalize(bookName);
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
