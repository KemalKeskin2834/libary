package com.kemalkeskin.product_service.repository;

import com.kemalkeskin.product_service.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

    boolean existsByPublisherName(String publisherName);
}
