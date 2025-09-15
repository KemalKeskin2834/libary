
package com.kemalkeskin.library.service.businessRules;

import com.kemalkeskin.library.core.exceptions.BusinessException;
import com.kemalkeskin.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookRules {

    private BookRepository bookRepository;

    @Autowired
    public BookRules(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void checkFoundById(int id){
        if(!bookRepository.findById(id).isPresent()){
            throw new BusinessException("don't found id= {0}"+id);
        }
    }

    public void repeatBookName(String bookName){

        if(bookRepository.existsByBookName(bookName)){
            throw new BusinessException("avaliabled book name");
        }
    }


}
