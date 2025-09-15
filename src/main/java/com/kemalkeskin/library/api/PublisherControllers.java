
package com.kemalkeskin.library.api;

import com.kemalkeskin.library.service.abstracts.PublisherService;
import com.kemalkeskin.library.service.dtoS.requests.PublisherRequest;
import com.kemalkeskin.library.service.dtoS.responses.PublisherResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/publishers")
@RestController
public class PublisherControllers {

    private PublisherService publisherService;

    @Autowired
    public PublisherControllers(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherResponse> listPublisher(){
        return publisherService.listPublisher();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  PublisherResponse getById(@PathVariable int id){
        return publisherService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public  void addPublisher(@Valid @RequestBody PublisherRequest publisherRequest){
        this.publisherService.addPublisher(publisherRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable int id,@Valid @RequestBody PublisherRequest publisherRequest){
        this.publisherService.update(id,publisherRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void deleteById(@PathVariable int id){
        this.publisherService.deleteById(id);
    }

}
