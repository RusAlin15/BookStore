package com.application.exemplary.dto;

import java.time.LocalDate;

import com.application.enums.Language;

public class ExemplaryCreateDto {
	private Integer id;
	private LocalDate publishedDate;
	private String code;
	private Integer pageNumbers;
	private Language language;
	private Integer bookId;
	private Integer publishingHouseId;

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

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getPublishingHouseId() {
		return publishingHouseId;
	}

	public void setPublishingHouseId(Integer publishingHouseId) {
		this.publishingHouseId = publishingHouseId;
	}

}
