package com.library.books.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.library.books.entity.BookEntity;
import com.library.books.model.BookModel;

public interface BooksServiceV2 {

	public Page<BookModel> getBooks(Pageable pageable);

	public BookModel getBook(Integer bookId);

	public List<BookModel> createBooks(List<BookModel> bookModels);

	public List<BookModel> updateBooks(List<BookModel> bookModels);

	public String deleteBooks(Integer bookId);

}
