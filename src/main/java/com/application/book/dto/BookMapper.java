package com.application.book.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.author.dto.AuthorMapper;
import com.application.book.Book;

@Component
public class BookMapper {

	private AuthorMapper authorMapper = new AuthorMapper();

	public BookDto book2BookDto(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setTitle(book.getTitle());
		bookDto.setIsbn(book.getIsbn());
		bookDto.setYear(book.getYearBook());
		bookDto.setCategory(book.getCategory());
		bookDto.setAuthors(book.getAuthors().stream().map((author) -> authorMapper.author2SimpleAuthorDto(author))
				.collect(Collectors.toSet()));

		return bookDto;
	}

	public List<BookDto> bookList2BookListDto(List<Book> books) {
		return books.stream().map(this::book2BookDto).collect(Collectors.toList());
	}

	public Book bookCreateDto2Book(BookCreateDto bookCreateDto) {
		Book book = new Book();
		book.setTitle(bookCreateDto.getTitle());
		book.setYearBook(bookCreateDto.getYear());
		book.setIsbn(bookCreateDto.getIsbn());
		book.setCategory(bookCreateDto.getCategory());

		return book;
	}

	public SimpleBookDto book2SimpleBookDto(Book book) {
		SimpleBookDto simpleBookDto = new SimpleBookDto();

		simpleBookDto.setId(book.getId());
		simpleBookDto.setTitle(book.getTitle());

		return simpleBookDto;
	}

	public BookExemplaryDto book2ExemplaryeBookDto(Book book) {
		BookExemplaryDto exemplaryBookDto = new BookExemplaryDto();

		exemplaryBookDto.setSimpleBookDto(this.book2SimpleBookDto(book));
		exemplaryBookDto.setSimpleAuthorsDto(book.getAuthors().stream()
				.map((author) -> authorMapper.author2SimpleAuthorDto(author)).collect(Collectors.toSet()));

		return exemplaryBookDto;
	}
}
