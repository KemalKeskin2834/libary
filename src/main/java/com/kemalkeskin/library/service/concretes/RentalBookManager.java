
package com.kemalkeskin.library.service.concretes;

import com.kemalkeskin.library.service.abstracts.RentalBookService;
import com.kemalkeskin.library.service.businessRules.RentalBookBusinessRules;
import com.kemalkeskin.library.service.dtoS.requests.RentalBookRequest;
import com.kemalkeskin.library.service.dtoS.responses.RentalBookResponse;
import com.kemalkeskin.library.core.mapper.ModelMapperService;
import com.kemalkeskin.library.entities.Book;
import com.kemalkeskin.library.entities.RentalBook;
import com.kemalkeskin.library.repository.BookRepository;
import com.kemalkeskin.library.repository.RentalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalBookManager implements RentalBookService {

    private RentalBookRepository rentalBookRepository;
    private ModelMapperService modelMapperService;
    private BookRepository bookRepository;
    private RentalBookBusinessRules businessRules;

    @Autowired
    public RentalBookManager(RentalBookRepository rentalBookRepository,ModelMapperService modelMapperService, BookRepository bookRepository,RentalBookBusinessRules businessRules) {
        this.rentalBookRepository = rentalBookRepository;
        this.modelMapperService=modelMapperService;
        this.bookRepository=bookRepository;
        this.businessRules=businessRules;
    }


    @Override
    public List<RentalBookResponse> listRentalBooks() {
        List<RentalBook> rentalBooks=rentalBookRepository.findAll();
        List<RentalBookResponse>rentalBookResponses=rentalBooks.stream().map(rentalBook -> modelMapperService.forResponse().map(rentalBook,RentalBookResponse.class)).collect(Collectors.toList());
        return rentalBookResponses;
    }

    @Override
    public void rentedBook(RentalBookRequest rentalBookRequest) {
        this.businessRules.checkIfBookId(rentalBookRequest.getBookId()); // kitap var mı diye kontrol sağlıyorum
        Book book=bookRepository.findById(rentalBookRequest.getBookId()).get();
        this.businessRules.checkIfBookIsAlreadyRented(book); //kitap durumunu kontrol ettik teslim edilmiş mi diye
        book.setStatus(true); // teslim edildiyse eğer o zaman kiralanıyor diye durumunu true (teslim edilmemiş duruma getiriyorum


        RentalBook rentalBook=new RentalBook();
        rentalBook.setBook(book);
        rentalBook.setRentedDate(LocalDate.now()); // kitap teslim alındığı tarih otomatik olarak db set ediliyor
        this.rentalBookRepository.save(rentalBook);
        bookRepository.save(book);
    }

    @Override
    public void returnbook(int id) {
        this.businessRules.checkIfRentedId(id);
        RentalBook rentalBookUpdate=this.rentalBookRepository.findById(id).get();
        rentalBookUpdate.setReturnDate(LocalDate.now()); // kitap teslim edildiği tarih otomatik olarak db set ediliyor
        Book book=rentalBookUpdate.getBook();
        book.setStatus(false); // teslim edildiği için tekrar kiralabilsin diye status değerini false yapıyoruz
        this.rentalBookRepository.save(rentalBookUpdate);
    }
}
