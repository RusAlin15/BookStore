package com.application.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.book.Book;
import com.application.book.BookService;
import com.application.exception.ResourceNotFoundException;
import com.application.publishing.PublishingHouse;
import com.application.publishing.PublishingHouseService;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private BookService bookService;
	@Autowired
	private PublishingHouseService publishingHouseService;

	public Exemplary createExemplary(Integer bookId, Integer publishingHouseId, Exemplary exemplary)
			throws ResourceNotFoundException {
		Book book = bookService.getBookById(bookId);
		book.addExemplary(exemplary);
		PublishingHouse publishingHouse = publishingHouseService.getPublishingHouseById(publishingHouseId);
		exemplary.setPublishingHouse(publishingHouse);
		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public void deleteExemplary(Integer exemplaryId) {
		try {
			exemplaryRepository.deleteById(exemplaryId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Exemplary", "Id", exemplaryId);
		}
	}

	public List<Exemplary> findExemplariesByBookId(Integer bookId) {
		return exemplaryRepository.findExemplariesByBookId(bookId);
		/*
		 * SELECT exemplary.id, exemplary.date, exemplary.code FROM
		 * administartion.exemplary INNER JOIN administration.book ON exemplary.book_id
		 * = book.id WHERE book.id = :bookId
		 */
	}

	public List<Exemplary> getExemplaries() {
		return exemplaryRepository.findAll();
	}

	public Exemplary getExemplaryById(Integer exemplaryId) {
		return exemplaryRepository.findById(exemplaryId)
				.orElseThrow(() -> new ResourceNotFoundException("Exemplary", "Id", exemplaryId));
	}
}
