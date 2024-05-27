package com.library.books.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.entity.BookEntity;

@Repository
public interface BooksRepositoryV2 extends JpaRepository<BookEntity, Integer> {

	  Page<BookEntity> findAll(Pageable pageable);

}
