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

import com.application.book.dto.BookCreateDto;
import com.application.book.dto.BookDto;
import com.application.book.dto.BookMapper;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookMapper bookMapper;

	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookCreateDto bookCreateDto) {
		Book createdBook = bookService.createBook(bookMapper.bookCreateDto2Book(bookCreateDto),
				bookCreateDto.getAuthorIds());
		return new ResponseEntity<BookDto>(bookMapper.book2BookDto(createdBook), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBook() {
		return new ResponseEntity<List<BookDto>>(bookMapper.bookList2BookListDto(bookService.getAllBooks()),
				HttpStatus.OK);
	}

	@GetMapping("/by-id/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
		return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
	}

	@GetMapping("/by-title/{title}")
	public ResponseEntity<List<Book>> findByTitle(@PathVariable("title") String title) {
		return new ResponseEntity<List<Book>>(bookService.findByTitle(title), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Integer id) {
		return new ResponseEntity<Book>(bookService.updateBook(book, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return new ResponseEntity<String>("Book " + id + " succesfuly deleted!", HttpStatus.OK);
	}

}