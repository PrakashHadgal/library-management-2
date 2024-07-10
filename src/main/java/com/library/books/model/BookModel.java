package com.library.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.books.entity.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class BookModel {

	public BookModel() {
		// TODO Auto-generated constructor stub
	}
	
	public BookModel(Integer bookId, String bookName, String bookDescription, Integer quantity, Long createdDate,
			Long modifiedDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@JsonProperty("bookId")
	private Integer bookId;

//	@NotEmpty(message = "Atleast 3 character is required of the book name")
	@JsonProperty("bookName")
	private String bookName;

	@JsonProperty("bookDescription")
	private String bookDescription;

//	@NotNull
//	@Size(max = 10000000, min = 1)
	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("createdDate")
	private Long createdDate;

	@JsonProperty("modifiedDate")
	private Long modifiedDate;

	public BookEntity mapModelToEntity(BookModel bookModel) {
		long epochTime = System.currentTimeMillis();
		Integer bkId = null;

		if (bookModel.getBookId() != null) {
			bkId = bookModel.getBookId();
		}
		/*
		 * return BookEntity.builder().bookId(bkId).bookName(bookModel.getBookName())
		 * .bookDescription(bookModel.getBookDescription()).quantity(bookModel.
		 * getQuantity()) .createdDate(epochTime).modifiedDate(epochTime).build();
		 */

		return new BookEntity(bkId, bookModel.getBookName(), bookModel.getBookDescription(), bookModel.getQuantity(),
				epochTime, epochTime);
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
