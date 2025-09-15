package com.kemalkeskin.library.service.abstracts;

import com.kemalkeskin.library.service.dtoS.requests.BookRequest;
import com.kemalkeskin.library.service.dtoS.requests.PublisherRequest;
import com.kemalkeskin.library.service.dtoS.responses.BookResponse;
import com.kemalkeskin.library.service.dtoS.responses.PublisherResponse;

import java.util.List;

public interface PublisherService {

    List<PublisherResponse> listPublisher();

    PublisherResponse getById(int id);

    void addPublisher(PublisherRequest publisherRequest);

    void update(int id,PublisherRequest publisherRequest);

    void deleteById(int id);
}