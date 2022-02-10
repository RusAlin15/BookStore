package com.application.exemplary;

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
import com.application.exemplary.dto.ExemplaryDTO;
import com.application.exemplary.dto.ExemplaryMapper;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@PostMapping("/{bookId}/{publisingHouseId}")
	public ResponseEntity<ExemplaryDTO> createExemplary(@PathVariable Integer bookId,
			@PathVariable Integer publisingHouseId, @RequestBody ExemplaryDTO exemplaryDTO)
			throws ResourceNotFoundException {
		Exemplary createdExemplary = exemplaryService.createExemplary(bookId, publisingHouseId,
				exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
		return new ResponseEntity<ExemplaryDTO>(exemplaryMapper.exemplary2ExemplaryDTO(createdExemplary),
				HttpStatus.CREATED);
	}

	@PostMapping("/{publisingHouseId}")
	public ResponseEntity<ExemplaryDTO> createExemplary(@PathVariable Integer publisingHouseId,
			@RequestBody ExemplaryDTO exemplaryDTO) throws ResourceNotFoundException {
		Exemplary createdExemplary = exemplaryService.createExemplary(publisingHouseId,
				exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
		return new ResponseEntity<ExemplaryDTO>(exemplaryMapper.exemplary2ExemplaryDTO(createdExemplary),
				HttpStatus.CREATED);
	}

	@GetMapping("/list/{bookId}")
	public List<ExemplaryDTO> findExemplariesByBookId(@PathVariable Integer bookId) {
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(exemplaryService.findExemplariesByBookId(bookId));
	}

	@DeleteMapping("/{exemplaryId}")
	public void deleteExemplary(@PathVariable Integer exemplaryId) {
		exemplaryService.deleteExemplary(exemplaryId);
	}

	@GetMapping
	public ResponseEntity<List<ExemplaryDTO>> getExemplaries() {
		return new ResponseEntity<List<ExemplaryDTO>>(
				exemplaryMapper.exemplaryList2Exemplary(exemplaryService.getExemplaries()), HttpStatus.OK);
	}

}
