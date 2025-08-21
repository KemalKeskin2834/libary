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

        if(!authorRepository.findById(id).isPresent()){
            throw new BusinessException("Don't found id= "+ id);
        }
    }

    public void checkFoundAuthorName(String authorName){
        if(authorRepository.existsByAuthorName(authorName)){
            throw new BusinessException("name is already taken= "+ authorName);
        }
    }


}
