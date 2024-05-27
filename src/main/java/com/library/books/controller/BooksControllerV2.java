package com.library.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.exception.ApplicationException;
import com.library.books.exception.ErrorCodes;
import com.library.books.model.BookModel;
import com.library.books.service.BooksServiceV2;

//@RestController("library")
@RestController
@RequestMapping("library/v2/books")
public class BooksControllerV2 {

	@Autowired
	private BooksServiceV2 booksService;

	@PostMapping
	@ResponseBody
	// @PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<List<BookModel>> createBooks(@RequestBody List<BookModel> bookModels) {
		validateRequest(bookModels);
		return ResponseEntity.status(HttpStatus.CREATED).body(booksService.createBooks(bookModels));
	}

	private void validateRequest(List<BookModel> bookModels) {
		for (BookModel book : bookModels) {
			if (book.getBookName() == null || book.getBookName().isEmpty() || book.getBookDescription() == null
					|| book.getBookDescription().isEmpty() || book.getBookId() <= 0) {
				throw new ApplicationException(ErrorCodes.BAD_REQUEST_CODE,
						String.format("Book Name, Book description, Quantity should not be empty"),
						HttpStatus.BAD_REQUEST);
			}
		}
	}

	@PutMapping
	@ResponseBody
	//// @PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<List<BookModel>> updateBooks(@RequestBody List<BookModel> bookModels) {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.updateBooks(bookModels));
	}

	@GetMapping
	@ResponseBody
	// @PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<Page<BookModel>> getBooks(@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "3") int size,
			@RequestParam(defaultValue = "bookId,desc") String[] sort) {

		List<Order> orders = new ArrayList<Order>();
		if (sort != null) {
			if (sort[0].contains(",")) {
				for (String sortOrder : sort) {
					String[] _sort = sortOrder.split(",");
					orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
				}
			} else {
				orders.add(new Order(getSortDirection(sort[1]), sort[0]));
			}
		}
		Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
		return ResponseEntity.status(HttpStatus.OK).body(booksService.getBooks(pagingSort));
	}

	@GetMapping("book/{id}")
	@ResponseBody
	//// @PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<BookModel> getBook(@PathVariable("id") Integer bookId) {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.getBook(bookId));
	}

	@DeleteMapping("book/{id}")
	@ResponseBody
	//// @PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<String> deleteBooks(@PathVariable("id") Integer bookId) {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.deleteBooks(bookId));
	}

	private Sort.Direction getSortDirection(String direction) {
		if (direction.equals("asc")) {
			return Sort.Direction.ASC;
		} else if (direction.equals("desc")) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}
}