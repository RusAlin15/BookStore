package com.application.author;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.book.Book;
import com.application.book.BookService;
import com.application.exception.ResourceNotFoundException;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookService bookService;

	public Author createAuthor(Author author) {
		return authorRepository.saveAndFlush(author);
	}

	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}

	public Author getAuthorById(Integer id) {
		return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "Id", id));
	}

	public void deleteAuthorById(Integer id) {

		Author author = this.getAuthorById(id);
		Set<Book> books = author.getBooks();

		books.forEach((book) -> bookService.deleteBookById(book.getId()));
		authorRepository.deleteById(id);

	}

	public Author updateAuthorById(Author author, Integer id) {
		Author updateAuthor = getAuthorById(id);
		updateAuthor.setName(author.getName());
		updateAuthor.setBirthDate(author.getBirthDate());
		updateAuthor.setGender(author.getGender());
		updateAuthor.setDeathDate(author.getDeathDate());
		updateAuthor.setNationality(author.getNationality());
		authorRepository.flush();
		return updateAuthor;
	}

	public Author getAuthorByName(String name) {
		return authorRepository.findByName(name);
	}

	public List<Author> getAliveAuthors() {
		return authorRepository.findByDeathDateIsNull();
	}

	public List<Author> getAllByNationality(String nationality) {
		return authorRepository.findAllByNationality(nationality);
	}

	public List<Author> getDeadAuthors() {
		return authorRepository.findByDeathDateNotNull();
	}

}