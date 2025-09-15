
package com.kemalkeskin.library.api;

import com.kemalkeskin.library.service.abstracts.AuthorService;
import com.kemalkeskin.library.service.dtoS.requests.AuthorRequest;
import com.kemalkeskin.library.service.dtoS.responses.AuthorIsBooksResponse;
import com.kemalkeskin.library.service.dtoS.responses.AuthorResponse;
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
    public List<AuthorResponse> listAuthors(){
        return authorService.listAuthors();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse getById(@PathVariable int id){
        return authorService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor( @Valid @RequestBody AuthorRequest authorRequest){
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


    @GetMapping("/books")
    public List<AuthorIsBooksResponse>authorIsBooks(){
        return authorService.authorIsBooks();
    }

}

