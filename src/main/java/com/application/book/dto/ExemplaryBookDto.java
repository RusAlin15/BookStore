package com.application.book.dto;

import java.util.Set;

import com.application.author.dto.SimpleAuthorDto;

public class ExemplaryBookDto {

	private SimpleBookDto book;
	private Set<SimpleAuthorDto> authors;

	public SimpleBookDto getSimpleBookDto() {
		return book;
	}

	public void setSimpleBookDto(SimpleBookDto simpleBookDto) {
		this.book = simpleBookDto;
	}

	public Set<SimpleAuthorDto> getSimpleAuthorsDto() {
		return authors;
	}

	public void setSimpleAuthorsDto(Set<SimpleAuthorDto> simpleAuthorsDto) {
		this.authors = simpleAuthorsDto;
	}
}
