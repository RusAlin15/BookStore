package com.application.exemplary.dto;

import java.time.LocalDate;

import com.application.book.dto.BookExemplaryDto;
import com.application.enums.Language;

public class ExemplaryDto {
	private Integer id;
	private String code;
	private Integer pageNumbers;
	private Language language;
	private LocalDate publishedDate;
	private BookExemplaryDto bookDto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(Integer pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public BookExemplaryDto getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookExemplaryDto bookDto) {
		this.bookDto = bookDto;
	}

}
