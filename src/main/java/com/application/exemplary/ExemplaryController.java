package com.application.exemplary;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.ResourceNotFoundException;
import com.application.exemplary.dto.ExemplaryCreateDto;
import com.application.exemplary.dto.ExemplaryDto;
import com.application.exemplary.dto.ExemplaryMapper;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@PostMapping
	public ResponseEntity<ExemplaryDto> createExemplary(@RequestBody ExemplaryCreateDto exemplaryCreateDto)
			throws ResourceNotFoundException {
		Exemplary exemplary = exemplaryMapper.exemplaryCreateDto2Exemplary(exemplaryCreateDto);

		return new ResponseEntity<ExemplaryDto>(exemplaryMapper.exemplary2ExemplaryDto(exemplaryService
				.createExemplary(exemplaryCreateDto.getBookId(), exemplaryCreateDto.getPublishingHouseId(), exemplary)),
				HttpStatus.CREATED);
	}

	@GetMapping("/by-id/{bookId}")
	public ResponseEntity<List<ExemplaryDto>> findExemplariesByBookId(@PathVariable Integer bookId) {
		return new ResponseEntity<List<ExemplaryDto>>(
				exemplaryMapper.exemplaryList2ExemplaryDtoList(exemplaryService.findExemplariesByBookId(bookId)),
				HttpStatus.OK);
	}

	@DeleteMapping("/{exemplaryId}")
	public ResponseEntity<String> deleteExemplary(@PathVariable Integer exemplaryId) {
		exemplaryService.deleteExemplary(exemplaryId);
		return new ResponseEntity<String>("Exemplary " + exemplaryId + " succesfuly deleted!", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ExemplaryDto>> getExemplaries() {
		return new ResponseEntity<List<ExemplaryDto>>(
				exemplaryMapper.exemplaryList2ExemplaryDto(exemplaryService.getExemplaries()), HttpStatus.OK);
	}

	@GetMapping("/free/{bookId}/{strStartDate}/{strEndDate}")
	public ResponseEntity<List<ExemplaryDto>> getFreeExemplaries(@PathVariable Integer bookId,
			@PathVariable String strStartDate, @PathVariable String strEndDate) {
		LocalDate startDate = LocalDate.parse(strStartDate);
		LocalDate endDate = LocalDate.parse(strEndDate);
		List<Exemplary> exemplaries = exemplaryService.getFreeExemplaries(bookId, startDate, endDate);
		return new ResponseEntity<List<ExemplaryDto>>(exemplaryMapper.exemplaryList2ExemplaryDto(exemplaries),
				HttpStatus.OK);
	}
}
