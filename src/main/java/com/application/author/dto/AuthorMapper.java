package com.application.author.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.author.Author;

@Service
public class AuthorMapper {

	public Author authorDTO2author(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setId(authorDTO.getId());
		author.setBirthDate(authorDTO.getBirthDate());
		author.setDeathDate(authorDTO.getDeathDate());
		author.setGender(authorDTO.getGender());
		author.setName(authorDTO.getName());
		author.setNationality(authorDTO.getNationality());
		return author;
	}

	public AuthorDTO author2authorDTO(Author author) {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.getId());
		authorDTO.setBirthDate(author.getBirthDate());
		authorDTO.setDeathDate(author.getDeathDate());
		authorDTO.setGender(author.getGender());
		authorDTO.setName(author.getName());
		authorDTO.setNationality(author.getNationality());
		return authorDTO;
	}

	public List<AuthorDTO> authorList2authorListDTO(List<Author> authors) {

		return authors.stream().map(this::author2authorDTO).collect(Collectors.toList());
	}

}
