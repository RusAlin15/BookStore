package com.application.book.dto;

import java.time.LocalDate;
import java.util.Set;

import com.application.enums.LiteraryCategory;

public class BookDTO {
	private Integer id;
	private String title;
	private LocalDate year;
	private String isbn;
	private LiteraryCategory category;
	private Set<String> authors;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LiteraryCategory getCategory() {
		return category;
	}

	public void setCategory(LiteraryCategory category) {
		this.category = category;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

}
