package com.library.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.books.entity.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookModel {

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
		return BookEntity.builder().bookId(bkId).bookName(bookModel.getBookName())
				.bookDescription(bookModel.getBookDescription()).quantity(bookModel.getQuantity())
				.createdDate(epochTime).modifiedDate(epochTime).build();
	}

}
