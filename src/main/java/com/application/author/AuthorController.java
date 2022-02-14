package com.application.author;

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

import com.application.author.dto.AuthorCreateDto;
import com.application.author.dto.AuthorDto;
import com.application.author.dto.AuthorMapper;
import com.application.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthorMapper authorMapper;

	@PostMapping
	public ResponseEntity<AuthorCreateDto> createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
		Author author = authorService.createAuthor(authorMapper.authorCreateDto2author(authorCreateDto));
		return new ResponseEntity<AuthorCreateDto>(authorMapper.author2authorCreateDto(author), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<AuthorDto>> getAllAuthor() {
		return new ResponseEntity<List<AuthorDto>>(authorMapper.authorList2authorListDto(authorService.getAllAuthor()),
				HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer id) {
		return new ResponseEntity<AuthorDto>(authorMapper.author2authorDto(authorService.getAuthorById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<AuthorDto> getAuthorByname(@PathVariable String name) {
		return new ResponseEntity<AuthorDto>(authorMapper.author2authorDto(authorService.getAuthorByName(name)),
				HttpStatus.OK);
	}

	@GetMapping("/alive")
	public ResponseEntity<List<AuthorDto>> getAliveAuthors() {
		return new ResponseEntity<List<AuthorDto>>(
				authorMapper.authorList2authorListDto(authorService.getAliveAuthors()), HttpStatus.OK);
	}

	@GetMapping("/dead")
	public ResponseEntity<List<AuthorDto>> getDeadAuthors() {
		return new ResponseEntity<List<AuthorDto>>(
				authorMapper.authorList2authorListDto(authorService.getDeadAuthors()), HttpStatus.OK);
	}

	@GetMapping("/nationality/{nationality}")
	public ResponseEntity<List<AuthorDto>> getByNationality(@PathVariable String nationality) {
		return new ResponseEntity<List<AuthorDto>>(
				authorMapper.authorList2authorListDto(authorService.getAllByNationality(nationality)), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorCreateDto authorCreateDto,
			@PathVariable Integer id) throws ResourceNotFoundException {
		Author author = authorMapper.authorCreateDto2author(authorCreateDto);
		return new ResponseEntity<AuthorDto>(authorMapper.author2authorDto(authorService.updateAuthorById(author, id)),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAuthorById(@PathVariable Integer id) {
		authorService.deleteAuthorById(id);
		return new ResponseEntity<String>("Author " + id + " succesfuly deleted!", HttpStatus.OK);
	}
}