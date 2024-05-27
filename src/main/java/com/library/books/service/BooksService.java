package com.library.books.service;

import java.util.List;

import com.library.books.model.BookModel;
import com.library.books.model.BookSearchModel;

public interface BooksService {

	public List<BookModel> getBooks();

	public BookModel getBook(Integer bookId);

	public List<BookModel> createBooks(List<BookModel> bookModels);

	public List<BookModel> updateBooks(List<BookModel> bookModels);

	public String deleteBooks(Integer bookId);

}
