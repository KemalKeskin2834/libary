package com.kemalkeskin.library.repository;

import com.kemalkeskin.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    boolean existsByBookName(String bookName);

    List<Book>findByOrderByPageNumbers();

    List<Book>findByStatusFalse();

}
