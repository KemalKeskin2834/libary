package com.kemalkeskin.product_service.business.businessRules;

import com.kemalkeskin.product_service.core.exception.BusinessException;
import com.kemalkeskin.product_service.repository.BookRepository;
import org.springframework.stereotype.Component;


@Component
public class BookRules {

    private BookRepository bookRepository;

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
