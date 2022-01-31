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

import com.application.author.dto.AuthorDTO;
import com.application.author.dto.AuthorMapper;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthorMapper authorMapper;

	@PostMapping
	public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
		Author author = authorService.createAuthor(authorMapper.authorDTO2author(authorDTO));
		return new ResponseEntity<AuthorDTO>(authorMapper.author2authorDTO(author), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<AuthorDTO> getAllAuthor() {
		return authorMapper.authorList2authorListDTO(authorService.getAllAuthor());
	}

	@GetMapping("/id/{id}")
	public AuthorDTO getAuthorById(@PathVariable Integer id) {
		return authorMapper.author2authorDTO(authorService.getAuthorById(id));
	}

	@GetMapping("/name/{name}")
	public AuthorDTO getAuthorByname(@PathVariable String name) {
		return authorMapper.author2authorDTO(authorService.getAuthorByName(name));
	}

	@GetMapping("/alive")
	public List<AuthorDTO> getAliveAuthors() {
		return authorMapper.authorList2authorListDTO(authorService.getAliveAuthors());
	}

	@GetMapping("/dead")
	public List<AuthorDTO> getDeadAuthors() {
		return authorMapper.authorList2authorListDTO(authorService.getDeadAuthors());
	}

	@GetMapping("/nationality/{nationality}")
	public List<AuthorDTO> getByNationality(@PathVariable String nationality) {
		return authorMapper.authorList2authorListDTO(authorService.getAllByNationality(nationality));
	}

	@PutMapping("/{id}")
	public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable Integer id) {
		Author author = authorMapper.authorDTO2author(authorDTO);
		return authorMapper.author2authorDTO(authorService.updateAuthorById(author, id));
	}

	@DeleteMapping("/{id}")
	public void deleteAuthorById(@PathVariable Integer id) {
		authorService.deleteAuthorById(id);
	}
}