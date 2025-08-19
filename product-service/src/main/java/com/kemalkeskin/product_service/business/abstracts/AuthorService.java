package com.kemalkeskin.product_service.business.abstracts;

import com.kemalkeskin.product_service.business.dtoS.requests.AuthorRequest;
import com.kemalkeskin.product_service.business.dtoS.requests.BookRequest;
import com.kemalkeskin.product_service.business.dtoS.responses.AuthorResponse;
import com.kemalkeskin.product_service.business.dtoS.responses.BookResponse;

import java.util.List;

public interface AuthorService {

    List<AuthorResponse> listBooks();

    AuthorResponse getById(int id);

    void addAuthor(AuthorRequest authorRequest);

    void updateAuthor(int id,AuthorRequest authorRequest);

    void deleteById(int id);


}
