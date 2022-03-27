package com.application.exemplary;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {

	@Query(value = "SELECT exemplary FROM Exemplary exemplary INNER JOIN exemplary.book book WHERE book.id = :bookId")
	List<Exemplary> findExemplariesByBookId(@Param(value = "bookId") Integer bookId);

	@Query(value = "SELECT DISTINCT exemplary FROM Exemplary exemplary INNER JOIN exemplary.book book LEFT JOIN "
			+ "exemplary.appointments appointments WHERE exemplary.id NOT IN "
			+ "(SELECT ex.id FROM Appointment ap JOIN ap.exemplary ex WHERE ?2 <= ap.endDate "
			+ "AND ?3 >= ap.startDate) AND (book.id =?1)  ")
	List<Exemplary> findFreeExemplary(Integer bookId, LocalDate startDate, LocalDate endDate);
}
