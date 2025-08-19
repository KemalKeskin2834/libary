package com.kemalkeskin.product_service.business.businessRules;

import com.kemalkeskin.product_service.core.exception.BusinessException;
import com.kemalkeskin.product_service.repository.PublisherRepository;
import org.springframework.stereotype.Component;



@Component
public class PublisherRules {

    private PublisherRepository publisherRepository;

    public PublisherRules(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    public void checkFoundId(int id){
        if(!publisherRepository.findById(id).isPresent()){
            throw new BusinessException("Don't found id= {0}"+ id);
        }
    }

    public void checkFoundPublisherName(String publisherName){
        if(publisherRepository.existsByPublisherName(publisherName)){
            throw new BusinessException("avaliabled publisher name");
        }
    }
}
