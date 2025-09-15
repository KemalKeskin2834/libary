
package com.kemalkeskin.library.repository;

import com.kemalkeskin.library.entities.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    private Author author;

    @BeforeEach
    void setUp() {
        author=new Author();
        author.setAuthorName("Nazım Hikmet");
        this.authorRepository.save(author);
    }

    @Test
    void findAll(){

        List<Author>authors=authorRepository.findAll();

        assertEquals("Nazım Hikmet",author.getAuthorName());
    }


    @Test
    void getById(){

        Author authorGet=this.authorRepository.findById(author.getId()).get();
        assertEquals("Nazım Hikmet",author.getAuthorName());
        assertNotNull(authorGet);
    }

    @Test
    void add(){

        Author authorAdd=new Author();
        authorAdd.setAuthorName("Ziya Gökalp");
        this.authorRepository.save(authorAdd);
        assertEquals(2,authorRepository.findAll().size());
        assertEquals("Ziya Gökalp",authorRepository.findAll().get(1).getAuthorName());
    }

    @Test
    void update(){

        Author authorUpdate=this.authorRepository.findById(author.getId()).get();
        authorUpdate.setAuthorName("Mehmet Akif Ersoy");
        this.authorRepository.save(authorUpdate);

        assertEquals("Mehmet Akif Ersoy",author.getAuthorName());
    }

    @Test
    void delete(){


        this.authorRepository.deleteById(author.getId());

        assertEquals(0,authorRepository.findAll().size());

    }

}
