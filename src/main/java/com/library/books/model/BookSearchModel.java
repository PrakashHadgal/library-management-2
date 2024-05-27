package com.library.books.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BookSearchModel {

	@JsonProperty("bookIds")
	private List<Integer> bookIds;

	@JsonProperty("bookName")
	private String bookName;
}
