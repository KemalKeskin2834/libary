
package com.kemalkeskin.library.service.abstracts;

import com.kemalkeskin.library.service.dtoS.requests.BookRequest;
import com.kemalkeskin.library.service.dtoS.responses.AuthorResponse;
import com.kemalkeskin.library.service.dtoS.responses.BookResponse;

import java.util.List;

public interface BookService {

    List<BookResponse>listBooks();

    BookResponse getById(int id);

    void addBook(BookRequest bookRequest);

    void updateBook(int id,BookRequest bookRequest);

    void deleteById(int id);

    List<BookResponse>sortedPageNumbers();

    List<BookResponse>rentableBooks();
}
