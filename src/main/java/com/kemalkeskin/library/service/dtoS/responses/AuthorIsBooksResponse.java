
package com.kemalkeskin.library.service.dtoS.responses;

import java.util.List;

public class AuthorIsBooksResponse {

    private int id;

    private String authorName;

    private List<String> bookName;

    public AuthorIsBooksResponse() {
    }

    public AuthorIsBooksResponse(int id, String authorName, List<String> bookName) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
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

    public List<String> getBookName() {
        return bookName;
    }

    public void setBookName(List<String> bookName) {
        this.bookName = bookName;
    }
}
