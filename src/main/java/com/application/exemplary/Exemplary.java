package com.application.exemplary;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.appointment.Appointment;
import com.application.book.Book;
import com.application.enums.Language;
import com.application.publishing.PublishingHouse;

@Entity(name = "exemplary")
@Table(name = "exemplary", schema = "administration")
public class Exemplary {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "published_date", nullable = false)
	private LocalDate publishedDate;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "page_numbers")
	private Integer pageNumbers;

	@Column(name = "language", nullable = false)
	@Enumerated(EnumType.STRING)
	private Language language;

	@ManyToOne()
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne()
	@JoinColumn(name = "publishing_house_id")
	private PublishingHouse publishingHouse;

	@OneToMany(mappedBy = "exemplary", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Appointment> appointments;

	public Integer getId() {
		return id;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate date) {
		this.publishedDate = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(Integer pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public PublishingHouse getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(PublishingHouse publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
	}

}
