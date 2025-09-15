
package com.kemalkeskin.library.service.businessRules;

import com.kemalkeskin.library.core.exceptions.BusinessException;
import com.kemalkeskin.library.entities.Book;
import com.kemalkeskin.library.repository.BookRepository;
import com.kemalkeskin.library.repository.RentalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalBookBusinessRules {


    private BookRepository bookRepository;
    private RentalBookRepository rentalBookRepository;

    @Autowired
    public RentalBookBusinessRules(BookRepository bookRepository,RentalBookRepository rentalBookRepository) {
        this.bookRepository = bookRepository;
        this.rentalBookRepository=rentalBookRepository;
    }


    public void checkIfRentedId(int id){
        if(!rentalBookRepository.findById(id).isPresent()){
            throw new BusinessException("don't found id");
        }
    }

    public void checkIfBookId(int id){
        if(!bookRepository.findById(id).isPresent()){
            throw new BusinessException("bu id göre kitap yok");
        }
    }

    public void checkIfBookIsAlreadyRented(Book book) {
        if (book.isStatus()) {
            throw new BusinessException("Kitap teslim edilmemiş durumda");
        }
    }
}
