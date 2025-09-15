
package com.kemalkeskin.library.service.concretes;

import com.kemalkeskin.library.service.abstracts.PublisherService;
import com.kemalkeskin.library.service.businessRules.PublisherRules;
import com.kemalkeskin.library.service.dtoS.requests.PublisherRequest;
import com.kemalkeskin.library.service.dtoS.responses.PublisherResponse;
import com.kemalkeskin.library.core.mapper.ModelMapperService;
import com.kemalkeskin.library.core.utility.MessageProducer;
import com.kemalkeskin.library.entities.Publisher;
import com.kemalkeskin.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherManager implements PublisherService {

    private PublisherRepository publisherRepository;
    private ModelMapperService modelMapperService;
    private PublisherRules publisherRules;
    private MessageProducer messageProducer;

    @Autowired
    public PublisherManager(PublisherRepository publisherRepository,ModelMapperService modelMapperService,MessageProducer messageProducer,PublisherRules publisherRules) {
        this.publisherRepository = publisherRepository;
        this.modelMapperService=modelMapperService;
        this.publisherRules=publisherRules;
        this.messageProducer=messageProducer;
    }

    @Override
    public List<PublisherResponse> listPublisher() {
        return publisherRepository.findAll().stream().map(publisher ->modelMapperService.forResponse().map(publisher, PublisherResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PublisherResponse getById(int id) {
        this.publisherRules.checkFoundId(id);
        Optional<Publisher> publisher = this.publisherRepository.findById(id);
        return modelMapperService.forResponse().map(publisher, PublisherResponse.class);
    }

    @Override
    public void addPublisher(PublisherRequest publisherRequest) {
        this.publisherRules.checkFoundPublisherName(publisherRequest.getPublisherName());
        Publisher publisher=this.modelMapperService.forRequest().map(publisherRequest, Publisher.class);
        this.publisherRepository.save(publisher);
        messageProducer.sendMessage("saved publisher: "+publisherRequest.getPublisherName());

    }

    @Override
    public void update(int id, PublisherRequest publisherRequest) {
        this.publisherRules.checkFoundId(id);
        this.publisherRules.checkFoundPublisherName(publisherRequest.getPublisherName());
        Publisher publisher=this.publisherRepository.findById(id).get();
        modelMapperService.forRequest().map(publisherRequest,publisher);
        this.publisherRepository.save(publisher);
        messageProducer.sendMessage("updated publisher: "+publisherRequest.getPublisherName());

    }

    @Override
    public void deleteById(int id) {
        this.publisherRules.checkFoundId(id);
        this.publisherRepository.deleteById(id);
        messageProducer.sendMessage("deleted publisher: "+id);
    }
}
