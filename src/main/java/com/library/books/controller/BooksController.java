package com.library.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.BookModel;
import com.library.books.service.BooksService;

//@RestController("library")
@RestController
@RequestMapping("library/books")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping
	@ResponseBody
	//@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<List<BookModel>> createBooks(@RequestBody List<BookModel> bookModels) {
		return ResponseEntity.status(HttpStatus.CREATED).body(booksService.createBooks(bookModels));
	}

	@PutMapping
	@ResponseBody
	////@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<List<BookModel>> updateBooks(@RequestBody List<BookModel> bookModels) {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.updateBooks(bookModels));
	}

	@GetMapping
	@ResponseBody
	//@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<List<BookModel>> getBooks() {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.getBooks());
	}

	@GetMapping("book/{id}")
	@ResponseBody
	////@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<BookModel> getBook(@PathVariable("id") Integer bookId) {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.getBook(bookId));
	}

	@DeleteMapping("book/{id}")
	@ResponseBody
	////@PreAuthorize("hasAuthority('APPROLE_Admin')")
	public ResponseEntity<String> deleteBooks(@PathVariable("id") Integer bookId) {
		return ResponseEntity.status(HttpStatus.OK).body(booksService.deleteBooks(bookId));
	}
}