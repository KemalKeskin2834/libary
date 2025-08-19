package com.kemalkeskin.product_service.repository;

import com.kemalkeskin.product_service.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    boolean existsByBookName(String bookName);

    List<Book>findByOrderByPageNumbers();

}
