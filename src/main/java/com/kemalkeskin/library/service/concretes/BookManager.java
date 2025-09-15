
package com.kemalkeskin.library.service.concretes;

import com.kemalkeskin.library.service.abstracts.BookService;
import com.kemalkeskin.library.service.businessRules.BookRules;
import com.kemalkeskin.library.service.dtoS.requests.BookRequest;
import com.kemalkeskin.library.service.dtoS.responses.BookResponse;
import com.kemalkeskin.library.core.mapper.ModelMapperService;
import com.kemalkeskin.library.core.utility.MessageProducer;
import com.kemalkeskin.library.entities.Book;
import com.kemalkeskin.library.repository.AuthorRepository;
import com.kemalkeskin.library.repository.BookRepository;
import com.kemalkeskin.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookManager implements BookService {


    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private ModelMapperService modelMapperService;
    private BookRules bookRules;
    private MessageProducer  messageProducer;


    @Autowired
    public BookManager(BookRepository bookRepository,ModelMapperService modelMapperService, BookRules bookRules, PublisherRepository publisherRepository
            ,AuthorRepository authorRepository,MessageProducer messageProducer) {
        this.bookRepository = bookRepository;
        this.modelMapperService =modelMapperService;
        this.bookRules=bookRules;
        this.publisherRepository=publisherRepository;
        this.authorRepository=authorRepository;
        this.messageProducer=messageProducer;
    }

    @Override
    public List<BookResponse> listBooks() {
        return bookRepository.findAll().stream().map(book ->modelMapperService.forResponse().map(book,BookResponse.class)).collect(Collectors.toList());
    }

    @Override
    public BookResponse getById(int id) {
        this.bookRules.checkFoundById(id);
        Optional<Book>book=bookRepository.findById(id);
        return modelMapperService.forResponse().map(book,BookResponse.class);
    }

    @Override
    public void addBook(BookRequest bookRequest) {
        this.bookRules.repeatBookName(bookRequest.getBookName());
        Book book=modelMapperService.forRequest().map(bookRequest, Book.class);
        this.bookRepository.save(book);
        messageProducer.sendMessage("saved book: "+bookRequest.getBookName());
    }

    @Override
    public void updateBook(int id, BookRequest bookRequest) {
        this.bookRules.checkFoundById(id);
        this.bookRules.repeatBookName(bookRequest.getBookName());
        Book bookUpdate=this.bookRepository.findById(id).get();
        this.modelMapperService.forRequest().map(bookRequest,bookUpdate);
        this.bookRepository.save(bookUpdate);
        messageProducer.sendMessage("updated book: "+bookRequest.getBookName());
    }


    @Override
    public void deleteById(int id) {
        this.bookRules.checkFoundById(id);
        this.bookRepository.deleteById(id);
        messageProducer.sendMessage("deleted book: "+id);
    }

    @Override
    public List<BookResponse> sortedPageNumbers() {
        List<Book>books=bookRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION.ASC,"pageNumbers"));
        List<BookResponse>bookResponses=books.stream().map(book->modelMapperService.forResponse().map(book,BookResponse.class)).collect(Collectors.toList());
        return bookResponses;
    }

    @Override
    public List<BookResponse> rentableBooks() {
        return bookRepository.findByStatusFalse().stream().map(book ->modelMapperService.forResponse().map(book,BookResponse.class)).collect(Collectors.toList());
    }
}

