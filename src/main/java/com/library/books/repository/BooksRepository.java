package com.library.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.books.entity.BookEntity;

@Repository
public interface BooksRepository extends CrudRepository<BookEntity, Integer> {

}
