package com.application.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.book.dto.BookDTO;
import com.application.book.dto.BookMapper;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookMapper bookMapper;

	@PostMapping
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
		Book createdBook = bookService.createBook(bookMapper.bookDTO2Book(bookDTO));
		return new ResponseEntity<BookDTO>(bookMapper.book2BookDTO(createdBook), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<BookDTO> getAllBook() {
		return bookMapper.bookList2BookListDTO(bookService.getAllBooks());
	}

	@GetMapping("/id/{id}")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@GetMapping("/title/{title}")
	public List<Book> findByTitle(@PathVariable("title") String title) {
		return bookService.findByTitle(title);

	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
		return bookService.updateBook(book, id);
	}

	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable Integer id) {
		bookService.deleteBookById(id);
	}

}