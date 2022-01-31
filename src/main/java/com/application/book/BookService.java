package com.application.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
	}

	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	public Book updateBook(Book book, Integer id) {
		Book bookUpdate = getBookById(id);
		bookUpdate.setTitle(book.getTitle());
		bookUpdate.setYearBook(book.getYearBook());
		bookUpdate.setIsbn(book.getIsbn());
		bookRepository.flush();
		return bookUpdate;
	}

	public List<Book> findByTitle(String title) {
		return bookRepository.findAllByTitle(title);

	}

}