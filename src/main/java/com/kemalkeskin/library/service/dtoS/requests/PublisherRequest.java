
package com.kemalkeskin.library.service.dtoS.requests;

import com.kemalkeskin.library.core.utility.StringNormalizer;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public class PublisherRequest {

    @NotBlank(message = "cannot be  blank")
    @NotNull(message = "cannot be  null")
    @Size(min = 3,message = "author name is minimum length 3 characters")
    private String publisherName;

    public PublisherRequest() {
    }

    public PublisherRequest(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = StringNormalizer.normalize(publisherName);
    }


}
