package com.application.book.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.book.Book;

@Component
public class BookMapper {

	public BookDTO book2BookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setYear(book.getYearBook());
		bookDTO.setCategory(book.getCategory());

		Set<String> authorsNames = book.getLinkedAuthors().stream().map(author -> author.getName())
				.collect(Collectors.toSet());

		bookDTO.setAuthors(authorsNames);
		return bookDTO;
	}

	public List<BookDTO> bookList2BookListDTO(List<Book> books) {
		return books.stream().map(this::book2BookDTO).collect(Collectors.toList());
	}

	public Book bookCreateDTO2Book(BookCreateDTO bookCreateDTO) {
		Book book = new Book();
		book.setTitle(bookCreateDTO.getTitle());
		book.setYearBook(bookCreateDTO.getYear());
		book.setIsbn(bookCreateDTO.getIsbn());
		book.setCategory(bookCreateDTO.getCategory());
		return book;
	}

}
