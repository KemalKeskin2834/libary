package com.kemalkeskin.library.repository;

import com.kemalkeskin.library.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

    boolean existsByPublisherName(String publisherName);
}
