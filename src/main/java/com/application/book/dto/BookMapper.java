package com.application.book.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.book.Book;

@Service
public class BookMapper {

	public BookDTO book2BookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setYear(book.getYearBook());
		bookDTO.setCategory(book.getCategory());
		return bookDTO;
	}

	public Book bookDTO2Book(BookDTO bookDTO) {
		Book book = new Book();
		book.setTitle(bookDTO.getTitle());
		book.setYearBook(bookDTO.getYear());
		book.setIsbn(bookDTO.getIsbn());
		book.setCategory(bookDTO.getCategory());
		return book;
	}

	public List<BookDTO> bookList2BookListDTO(List<Book> books) {
		return books.stream().map(this::book2BookDTO).collect(Collectors.toList());
	}
}
