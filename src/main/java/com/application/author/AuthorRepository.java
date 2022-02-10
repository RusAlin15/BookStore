package com.application.author;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public List<Author> findByDeathDateIsNull();

	public List<Author> findAllByNationality(String nationality);

	public List<Author> findByDeathDateNotNull();

	public Set<Author> findByIdIn(Set<Integer> authorIds);

	public Author findByName(String name);
}