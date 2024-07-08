package com.opencejav.LibMaster.repository;

import com.opencejav.LibMaster.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> { }
