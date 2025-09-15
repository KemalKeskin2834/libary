
package com.kemalkeskin.library.service.businessRules;

import com.kemalkeskin.library.core.exceptions.BusinessException;
import com.kemalkeskin.library.core.exceptions.BusinessException;

import com.kemalkeskin.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorBusinessRules {

    private AuthorRepository authorRepository;

    @Autowired
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
