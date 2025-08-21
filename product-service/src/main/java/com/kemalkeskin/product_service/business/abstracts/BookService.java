package com.kemalkeskin.product_service.business.abstracts;

import com.kemalkeskin.product_service.business.dtoS.requests.BookRequest;
import com.kemalkeskin.product_service.business.dtoS.responses.AuthorResponse;
import com.kemalkeskin.product_service.business.dtoS.responses.BookResponse;

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
