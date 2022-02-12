package com.application.author.dto;

import java.time.LocalDate;
import java.util.Set;

import com.application.book.dto.SimpleBookDto;
import com.application.enums.Gender;
import com.application.enums.Nationality;

public class AuthorDto {
	private Integer id;
	private String name;
	private LocalDate birthDate;
	private LocalDate deathDate;
	private Nationality nationality;
	private Gender gender;
	private Set<SimpleBookDto> booksDto;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Set<SimpleBookDto> getBooksDto() {
		return booksDto;
	}

	public void setBooksDto(Set<SimpleBookDto> booksDto) {
		this.booksDto = booksDto;
	}

}
