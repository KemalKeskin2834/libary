package com.kemalkeskin.product_service.business.dtoS.requests;


import com.kemalkeskin.product_service.core.utility.StringNormalizer;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;




public class AuthorRequest {

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    @Size(min = 3,message = "author name is minimum length 3 characters")
    private String authorName;

    public AuthorRequest() {
    }

    public AuthorRequest(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = StringNormalizer.normalize(authorName);
       //StringNormalizer => girdiğimiz metni düzeltmek için kullanılır.
    }
}
