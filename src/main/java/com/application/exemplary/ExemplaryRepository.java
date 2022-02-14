package com.application.exemplary;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {
	@Query(value = "SELECT exemplary FROM exemplary exemplary INNER JOIN exemplary.book book WHERE book.id = :bookId")
	List<Exemplary> findExemplariesByBookId(@Param(value = "bookId") Integer bookId);

	@Query(value = "SELECT exemplary FROM exemplary exemplary INNER JOIN exemplary.book book WHERE book.id = :bookId  INNER JOIN exemplary.appointment exemplary WHERE appointment.start_date <= :endDate AND appointment.end_date >=:startDate")
	List<Exemplary> findIntersection(@Param(value = "bookId") Integer bookId,
			@Param(value = "bookId") LocalDate startDate, @Param(value = "bookId") LocalDate endDate);
}
