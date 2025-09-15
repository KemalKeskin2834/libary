
package com.kemalkeskin.library.api;

import com.kemalkeskin.library.service.abstracts.BookService;
import com.kemalkeskin.library.service.dtoS.requests.BookRequest;
import com.kemalkeskin.library.service.dtoS.responses.BookResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/books")
@RestController
public class BookControllers {

    private BookService bookService;

    @Autowired
    public BookControllers(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> listBooks(){
        return  bookService.listBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookResponse getById(@PathVariable int id){
        return bookService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody BookRequest bookRequest){
        this.bookService.addBook(bookRequest);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable int id,@Valid @RequestBody BookRequest bookRequest){
        this.bookService.updateBook(id,bookRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id){
        this.bookService.deleteById(id);
    }

    @GetMapping("/sortedpagenumbers")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> sortedPageNumbers(){
        return bookService.sortedPageNumbers();
    }



    @GetMapping("/rentablebooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse>rentableBooks(){
        return this.bookService.rentableBooks();
    }

}
