
package com.kemalkeskin.library.repository;

import com.kemalkeskin.library.entities.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void findAll_shouldReturnAuthor(){
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Kültür yayınları");
        publisherRepository.save(publisher);

        Publisher publisher1 = new Publisher();;
        publisher1.setPublisherName("Saygı yayınları");
        publisherRepository.save(publisher1);

        List<Publisher>publishers=publisherRepository.findAll();

        assertEquals(2,publishers.size());
        assertEquals("Saygı yayınları",publishers.get(1).getPublisherName());
    }

    @Test
    void findById_shouldReturnAuthor() {
        // given
        Publisher publisher = new Publisher();;
        publisher.setPublisherName("Kültür yayınları");
        Publisher saved = publisherRepository.save(publisher);

        // when
        Optional<Publisher> found = publisherRepository.findById(saved.getId());

        // then
        assertTrue(found.isPresent());
        assertEquals("Kültür yayınları", found.get().getPublisherName());
    }

    @Test
    void saveAuthor_shouldPersistData() {
        // given
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Kültür yayınları");

        // when
        Publisher savePublisher = publisherRepository.save(publisher);

        // then
        assertEquals("Kültür yayınları", savePublisher. getPublisherName());
    }

    @Test
    void updatePublisher_shouldData(){

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Kültür yayınları");
        publisherRepository.save(publisher);

        publisher=publisherRepository.findById(publisher.getId()).orElseThrow();
        publisher.setPublisherName("Avcı yayınları");
        publisherRepository.save(publisher);


        assertEquals("Avcı yayınları",publisher.getPublisherName());


    }

    @Test
    void deleteByIdPublisher_shouldData(){

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Kültür yayınları");
        publisherRepository.save(publisher);


        publisherRepository.deleteById(publisher.getId());
        Optional<Publisher>publisher1=this.publisherRepository.findById(publisher.getId());

        assertTrue(publisher1.isEmpty());

    }

    @Test
    void existsByPublisherName(){

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Kültür yayınları");
        publisherRepository.save(publisher);

        boolean name=this.publisherRepository.existsByPublisherName(publisher.getPublisherName());
        assertTrue(name);
    }

}
