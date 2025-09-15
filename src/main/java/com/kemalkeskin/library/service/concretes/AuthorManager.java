package com.kemalkeskin.library.service.concretes;

import com.kemalkeskin.library.service.abstracts.AuthorService;
import com.kemalkeskin.library.service.businessRules.AuthorBusinessRules;
import com.kemalkeskin.library.service.dtoS.requests.AuthorRequest;
import com.kemalkeskin.library.service.dtoS.responses.AuthorIsBooksResponse;
import com.kemalkeskin.library.service.dtoS.responses.AuthorResponse;
import com.kemalkeskin.library.core.mapper.ModelMapperService;
import com.kemalkeskin.library.core.utility.MessageProducer;
import com.kemalkeskin.library.entities.Author;
import com.kemalkeskin.library.entities.Book;
import com.kemalkeskin.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorManager implements AuthorService {


    private AuthorRepository authorRepository;
    private ModelMapperService modelMapperService;
    private MessageProducer messageProducer;
    private AuthorBusinessRules authorBusinessRules;

    @Autowired
    public AuthorManager(AuthorRepository authorRepository, ModelMapperService modelMapperService,AuthorBusinessRules authorBusinessRules,MessageProducer messageProducer) {
        this.authorRepository = authorRepository;
        this.modelMapperService = modelMapperService;
        this.messageProducer=messageProducer;
        this.authorBusinessRules=authorBusinessRules;
    }

    @Override
    public List<AuthorResponse> listAuthors() {
        return authorRepository.findAll().stream().map(author->modelMapperService.forResponse().map(author, AuthorResponse.class)).collect(Collectors.toList());
    }

    @Override
    public AuthorResponse getById(int id) {
        this.authorBusinessRules.checkFoundId(id);
        Author author=this.authorRepository.findById(id).get();
        return  modelMapperService.forResponse().map(author, AuthorResponse.class);

    }

    @Override
    @Transactional
    public void addAuthor(AuthorRequest authorRequest) {
        this.authorBusinessRules.checkFoundAuthorName(authorRequest.getAuthorName());
        Author author=this.modelMapperService.forRequest().map(authorRequest,Author.class);
        this.authorRepository.save(author);

        messageProducer.sendMessage("new author saved: "+authorRequest.getAuthorName());

    }

    @Override
    public void updateAuthor(int id, AuthorRequest authorRequest) {

        this.authorBusinessRules.checkFoundId(id);
        this.authorBusinessRules.checkFoundAuthorName(authorRequest.getAuthorName());
        Author authorUpdate=this.authorRepository.findById(id).get();
        modelMapperService.forRequest().map(authorRequest,authorUpdate);
        this.authorRepository.save(authorUpdate);

        messageProducer.sendMessage("updated author id: "+id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.authorBusinessRules.checkFoundId(id);
        this.authorRepository.deleteById(id);
        messageProducer.sendMessage("deleted author: "+id);
    }

    @Override
    public List<AuthorIsBooksResponse> authorIsBooks() {
        List<Author> authors=authorRepository.findAll();
        List<AuthorIsBooksResponse>authorBookDemos=authors.stream().map(author->{

            AuthorIsBooksResponse response=new AuthorIsBooksResponse();
            response.setId(author.getId());
            response.setAuthorName(author.getAuthorName());

            List<String>bookName=author.getBookList().stream().map(Book::getBookName).collect(Collectors.toList());

            response.setBookName(bookName);
            return response;
        }).collect(Collectors.toList());



        return authorBookDemos;
    }
}