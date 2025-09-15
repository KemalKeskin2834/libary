
package com.kemalkeskin.library.service.abstracts;

import com.kemalkeskin.library.service.dtoS.requests.AuthorRequest;
import com.kemalkeskin.library.service.dtoS.responses.AuthorIsBooksResponse;
import com.kemalkeskin.library.service.dtoS.responses.AuthorResponse;

import java.util.List;

public interface AuthorService {

    List<AuthorResponse> listAuthors();

    AuthorResponse getById(int id);

    void addAuthor(AuthorRequest authorRequest);

    void updateAuthor(int id,AuthorRequest authorRequest);

    void deleteById(int id);

   List<AuthorIsBooksResponse>authorIsBooks();


}

