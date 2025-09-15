
package com.kemalkeskin.library.service.businessRules;

import com.kemalkeskin.library.core.exceptions.BusinessException;
import com.kemalkeskin.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class PublisherRules {

    private PublisherRepository publisherRepository;

    @Autowired
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
