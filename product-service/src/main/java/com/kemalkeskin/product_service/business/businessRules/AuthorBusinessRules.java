package com.kemalkeskin.product_service.business.businessRules;

import com.kemalkeskin.product_service.core.exception.BusinessException;
import com.kemalkeskin.product_service.entities.Author;

import com.kemalkeskin.product_service.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AuthorBusinessRules {

    private AuthorRepository authorRepository;

    public AuthorBusinessRules(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void checkFoundId(int id){

        Optional<Author> author=authorRepository.findById(id);

        if(!author.isPresent()){
            throw new BusinessException("Don't found id= "+ id);
        }
    }
/*
    public void checkFoundAuthorName(String authorName){

        Author author=authorRepository.existsAuthorName(authorName);

        if(Objects.nonNull(author)){
            throw new BusinessException("name is already taken= "+ authorName);
        }
    }
*/


}
