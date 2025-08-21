package com.kemalkeskin.product_service.business.abstracts;

import com.kemalkeskin.product_service.business.dtoS.requests.AuthorRequest;
import com.kemalkeskin.product_service.business.dtoS.responses.AuthorIsBooksResponse;
import com.kemalkeskin.product_service.business.dtoS.responses.AuthorResponse;

import java.util.List;

public interface AuthorService {

    List<AuthorResponse> listAuthors();

    AuthorResponse getById(int id);

    void addAuthor(AuthorRequest authorRequest);

    void updateAuthor(int id,AuthorRequest authorRequest);

    void deleteById(int id);

    List<AuthorIsBooksResponse>authorIsBooks();


}
