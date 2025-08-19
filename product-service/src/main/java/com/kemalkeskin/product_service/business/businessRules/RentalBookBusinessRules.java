package com.kemalkeskin.product_service.business.businessRules;

import com.kemalkeskin.product_service.core.exception.BusinessException;
import com.kemalkeskin.product_service.entities.Book;
import com.kemalkeskin.product_service.repository.BookRepository;
import com.kemalkeskin.product_service.repository.RentalBookRepository;
import org.springframework.stereotype.Component;

@Component
public class RentalBookBusinessRules {

    private BookRepository bookRepository;
    private RentalBookRepository rentalBookRepository;

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
