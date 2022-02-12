package com.application.book;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.author.Author;
import com.application.author.AuthorRepository;
import com.application.exception.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	public Book createBook(Book book, Set<Integer> authorIds) {
		Set<Author> authors = authorRepository.findByIdIn(authorIds);

		if (authorIds.size() != authors.size()) {
			throw new ResourceNotFoundException("Author", "Ids", authorIds);
		}

		authors.forEach(author -> author.addBook(book));
		book.setAuthors(authors);

		return bookRepository.saveAndFlush(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(Integer id) throws ResourceNotFoundException {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
	}

	public void deleteBookById(Integer id) {
		Book book = this.getBookById(id);

		Set<Author> authors = book.getAuthors();
		authors.forEach((author) -> author.removeBook(book));

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