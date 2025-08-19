package com.kemalkeskin.product_service.api;

import com.kemalkeskin.product_service.business.abstracts.AuthorService;
import com.kemalkeskin.product_service.business.dtoS.requests.AuthorRequest;
import com.kemalkeskin.product_service.business.dtoS.responses.AuthorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/authors")
@RestController
public class AuthorControllers {

    private AuthorService authorService;

    @Autowired
    public AuthorControllers(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> listBooks(){
        return authorService.listBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse getById(@PathVariable int id){
        return authorService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook( @Valid @RequestBody AuthorRequest authorRequest){
        this.authorService.addAuthor(authorRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@PathVariable int id,@Valid @RequestBody AuthorRequest authorRequest){
        this.authorService.updateAuthor(id,authorRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id){
        this.authorService.deleteById(id);
    }

}
