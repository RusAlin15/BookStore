package com.application.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.book.Book;
import com.application.book.BookService;
import com.application.publishingHouse.PublishingHouse;
import com.application.publishingHouse.PublishingHouseService;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private BookService bookService;
	@Autowired
	private PublishingHouseService publishingHouseService;

	public Exemplary createExemplary(Integer bookId, Integer publishingHouseId, Exemplary exemplary) {
		Book book = bookService.getBookById(bookId);
		book.addExemplary(exemplary);
		PublishingHouse publishingHouse = publishingHouseService.getPublishingHouseById(publishingHouseId);
		exemplary.setPublishingHouse(publishingHouse);
		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public void deleteExemplary(Integer exemplaryId) {
		exemplaryRepository.deleteById(exemplaryId);
	}

	public List<Exemplary> findExemplariesByBookId(Integer bookId) {
		return exemplaryRepository.findExemplariesByBookId(bookId);
		/*
		 * SELECT exemplary.id, exemplary.date, exemplary.code FROM
		 * administartion.exemplary INNER JOIN administration.book ON exemplary.book_id
		 * = book.id WHERE book.id = :bookId
		 */
	}
}
