
package com.kemalkeskin.library.service.dtoS.responses;

public class AuthorResponse {

    private int id;

    private String authorName;

    public AuthorResponse() {
    }

    public AuthorResponse(int id, String authorName) {
        this.id = id;
        this.authorName = authorName;
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
}
