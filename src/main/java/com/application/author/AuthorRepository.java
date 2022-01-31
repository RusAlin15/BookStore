package com.application.author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public List<Author> findByDeathDateIsNull();

	public List<Author> findAllByNationality(String nationality);

	public List<Author> findByDeathDateNotNull();

	public Author findByName(String name);
}