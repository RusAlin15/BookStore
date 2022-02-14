package com.application.author.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.author.Author;
import com.application.book.dto.BookMapper;

@Component
public class AuthorMapper {

	@Autowired
	BookMapper bookMapper;

	public Author authorCreateDto2author(AuthorCreateDto authorCreateDto) {
		Author author = new Author();
		author.setId(authorCreateDto.getId());
		author.setBirthDate(authorCreateDto.getBirthDate());
		author.setDeathDate(authorCreateDto.getDeathDate());
		author.setGender(authorCreateDto.getGender());
		author.setName(authorCreateDto.getName());
		author.setNationality(authorCreateDto.getNationality());
		return author;
	}

	public AuthorDto author2authorDto(Author author) {
		AuthorDto authorDto = new AuthorDto();
		authorDto.setId(author.getId());
		authorDto.setBirthDate(author.getBirthDate());
		authorDto.setDeathDate(author.getDeathDate());
		authorDto.setGender(author.getGender());
		authorDto.setName(author.getName());
		authorDto.setNationality(author.getNationality());
		authorDto.setBooksDto(author.getBooks().stream().map((book) -> bookMapper.book2SimpleBookDto(book))
				.collect(Collectors.toSet()));

		return authorDto;
	}

	public AuthorCreateDto author2authorCreateDto(Author author) {
		AuthorCreateDto authorCreateDto = new AuthorCreateDto();
		authorCreateDto.setId(author.getId());
		authorCreateDto.setBirthDate(author.getBirthDate());
		authorCreateDto.setDeathDate(author.getDeathDate());
		authorCreateDto.setGender(author.getGender());
		authorCreateDto.setName(author.getName());
		authorCreateDto.setNationality(author.getNationality());

		return authorCreateDto;
	}

	public List<AuthorDto> authorList2authorListDto(List<Author> list) {

		return list.stream().map(this::author2authorDto).collect(Collectors.toList());
	}

	public SimpleAuthorDto author2SimpleAuthorDto(Author author) {
		SimpleAuthorDto simpleAuthorDto = new SimpleAuthorDto();
		simpleAuthorDto.setId(author.getId());
		simpleAuthorDto.setName(author.getName());

		return simpleAuthorDto;
	}

}
