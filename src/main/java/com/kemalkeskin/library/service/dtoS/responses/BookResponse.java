
package com.kemalkeskin.library.service.dtoS.responses;



public class BookResponse {

    private int id;

    private String bookName;

    private int pageNumbers;

    private boolean status;

    private String authorName;

    private String publisherName;

    public BookResponse() {
    }

    public BookResponse(int id, String bookName, int pageNumbers, String authorName, String publisherName,boolean status) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.authorName = authorName;
        this.publisherName = publisherName;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
