package com.application.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findByTitle(String title);

	public List<Book> findAllByTitle(String title);
}