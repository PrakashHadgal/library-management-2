package com.library.books.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.books.entity.BookEntity;
import com.library.books.model.BookModel;
import com.library.books.repository.BooksRepositoryV2;
import com.library.books.service.BooksServiceV2;

@Service
public class BooksServiceImplV2 implements BooksServiceV2 {

	@Autowired
	private BooksRepositoryV2 booksRepository;

	@SuppressWarnings("unchecked")
	@Override
	public Page<BookModel> getBooks(Pageable pageable) {
		Page<BookEntity> allBooks = booksRepository.findAll(pageable);
		List<BookModel> allBookModel = new ArrayList<BookModel>();
		if (!allBooks.isEmpty()) {
			for (BookEntity entity : allBooks.getContent()) {
				allBookModel.add(entity.mapEntityToModel(entity));
			}
		}
		return new PageImpl<BookModel>(allBookModel, pageable, allBooks.getTotalElements());
	}

	@Override
	public BookModel getBook(Integer bookId) {
		Optional<BookEntity> bookEntity = booksRepository.findById(bookId);
		if (bookEntity.isPresent())
			return bookEntity.get().mapEntityToModel(bookEntity.get());
		return null;
	}

	@Override
	public List<BookModel> createBooks(List<BookModel> bookModels) {
		bookModels = bookModels.stream().map(bookModel -> {
			BookEntity bookEntity = booksRepository.save(bookModel.mapModelToEntity(bookModel));
			bookModel = bookEntity.mapEntityToModel(bookEntity);
			return bookModel;
		}).collect(Collectors.toList());
		return bookModels;
	}

	@Override
	public List<BookModel> updateBooks(List<BookModel> bookModels) {

		validateUpdate(bookModels);

		bookModels = bookModels.stream().map(bookModel -> {
			booksRepository.save(bookModel.mapModelToEntity(bookModel));
			return bookModel;
		}).collect(Collectors.toList());

		return bookModels;
	}

	private void validateUpdate(List<BookModel> bookModels) {
		bookModels.stream().forEach(book -> {
			if (book.getBookId() == null || book.getBookId() == 0) {
				throw new RuntimeException("Kindly Provide the Book Ids");
			}
		});
	}

	@Override
	public String deleteBooks(Integer bookId) {
		booksRepository.deleteById(bookId);
		return "Successfully Deleted";
	}

}
