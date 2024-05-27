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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class BookEntity {

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

	public BookModel mapEntityToModel(BookEntity bookEntity) {
		return BookModel.builder().bookId(bookEntity.getBookId()).bookName(bookEntity.getBookName())
				.bookDescription(bookEntity.getBookDescription()).quantity(bookEntity.getQuantity())
				.createdDate(bookEntity.getCreatedDate()).modifiedDate(bookEntity.getModifiedDate()).build();
	}
}
