package com.application.book;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.author.Author;
import com.application.enums.LiteraryCategory;
import com.application.exemplary.Exemplary;

@Entity
@Table(name = "book", schema = "administration")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "year", nullable = false)
	private LocalDate yearBook;

	@Column(name = "isbn", nullable = false, unique = true)
	private String isbn;

	@Column(name = "literary_category", nullable = false)
	private LiteraryCategory category;

	@OneToMany(mappedBy = "book", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Exemplary> exemplaries;

	@ManyToMany(mappedBy = "books", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private Set<Author> authors;

	public void addExemplary(Exemplary exemplary) {
		this.exemplaries.add(exemplary);
		exemplary.setBook(this);
	}

	public void removeExemplary(Exemplary exemplary) {
		this.exemplaries.remove(exemplary);
		exemplary.setBook(null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getYearBook() {
		return yearBook;
	}

	public void setYearBook(LocalDate yearBook) {
		this.yearBook = yearBook;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Exemplary> getExemplaries() {
		return exemplaries;
	}

	public void setExemplaries(Set<Exemplary> exemplaries) {
		this.exemplaries = exemplaries;
	}

	public LiteraryCategory getCategory() {
		return category;
	}

	public void setCategory(LiteraryCategory category) {
		this.category = category;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> linkedAuthors) {
		this.authors = linkedAuthors;
	}

}