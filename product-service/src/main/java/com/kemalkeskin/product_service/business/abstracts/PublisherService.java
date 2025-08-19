package com.kemalkeskin.product_service.business.abstracts;

import com.kemalkeskin.product_service.business.dtoS.requests.BookRequest;
import com.kemalkeskin.product_service.business.dtoS.requests.PublisherRequest;
import com.kemalkeskin.product_service.business.dtoS.responses.BookResponse;
import com.kemalkeskin.product_service.business.dtoS.responses.PublisherResponse;

import java.util.List;

public interface PublisherService {

    List<PublisherResponse> listPublisher();

    PublisherResponse getById(int id);

    void addPublisher(PublisherRequest publisherRequest);

    void update(int id,PublisherRequest publisherRequest);

    void deleteById(int id);
}
