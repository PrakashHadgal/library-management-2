package com.library.books.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.books.model.BookModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Setter
//@Getter
public class BookEntity {

	public BookEntity() {
		// TODO Auto-generated constructor stub
	}

	public BookEntity(Integer bookId, String bookName, String bookDescription, Integer quantity, Long createdDate,
			Long modifiedDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("bookId")
	private Integer bookId;

	@JsonProperty("bookName")
	private String bookName;

	@JsonProperty("bookDescription")
	private String bookDescription;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("createdDate")
	private Long createdDate;

	@JsonProperty("modifiedDate")
	private Long modifiedDate;

	/*
	 * public BookModel mapEntityToModel(BookEntity bookEntity) { return
	 * BookModel.builder().bookId(bookEntity.getBookId()).bookName(bookEntity.
	 * getBookName())
	 * .bookDescription(bookEntity.getBookDescription()).quantity(bookEntity.
	 * getQuantity())
	 * .createdDate(bookEntity.getCreatedDate()).modifiedDate(bookEntity.
	 * getModifiedDate()).build(); }
	 */

	public BookModel mapEntityToModel(BookEntity bookEntity) {
		return new BookModel(bookEntity.getBookId(), bookEntity.getBookName(), bookEntity.getBookDescription(),
				bookEntity.getQuantity(), bookEntity.getCreatedDate(), bookEntity.getModifiedDate());
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
