
package com.kemalkeskin.library.repository;

import com.kemalkeskin.library.entities.Author;
import com.kemalkeskin.library.entities.Book;
import com.kemalkeskin.library.entities.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private  AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    private Book book;
    Author author;
    Publisher publisher;

    @BeforeEach
    void setUp() {
        author=new Author();
        author.setAuthorName("kemal");
        authorRepository.save(author);

        publisher=new Publisher();
        publisher.setPublisherName("iş");
        publisherRepository.save(publisher);


        book=new Book();
        book.setBookName("Kaşağı");
        book.setStatus(false);
        book.setPageNumbers(200);
        book.setAuthor(author);
        book.setPublisher(publisher);

        bookRepository.save(book);
    }

    @Test
    void findAll_ShouldReturnBooks(){

        List<Book>books=this.bookRepository.findAll();

        assertEquals(1,books.size());
        assertEquals("Kaşağı",books.get(0).getBookName());
    }

    @Test
    void getById_ShouldReturnBook(){

        Book bookGet=this.bookRepository.findById(book.getId()).orElseThrow();

        assertNotNull(bookGet);
        assertEquals(200,bookGet.getPageNumbers());
    }

    @Test
    void addBook(){
        Book book2=new Book();
        book2.setBookName("yurt");
        book2.setStatus(false);
        book2.setPageNumbers(200);
        book2.setAuthor(author);
        book2.setPublisher(publisher);
        bookRepository.save(book2);

        List<Book>books=this.bookRepository.findAll();

        assertEquals("yurt",book2.getBookName());
        assertEquals(2,books.size());

    }

    @Test
    void updateBook(){

        Book bookUpdate=this.bookRepository.findById(book.getId()).orElseThrow();
        bookUpdate.setBookName("deneme");

        this.bookRepository.save(bookUpdate);

        assertEquals("deneme",book.getBookName());
        assertEquals(200,book.getPageNumbers());

    }

    @Test
    void deleteById(){

        this.bookRepository.deleteById(book.getId());

        List<Book> bookList= this.bookRepository.findAll();

        assertEquals(0,bookList.size());

    }

    @Test
    void existsByBookName(){

        boolean bookName=this.bookRepository.existsByBookName(book.getBookName());
        assertTrue(bookName);
    }


}
