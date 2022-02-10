package com.application.exemplary.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.exemplary.Exemplary;

@Component
public class ExemplaryMapper {
	public ExemplaryDTO exemplary2ExemplaryDTO(Exemplary exemplary) {
		ExemplaryDTO exemplaryDTO = new ExemplaryDTO();
		exemplaryDTO.setId(exemplary.getId());
		exemplaryDTO.setPublishedDate(exemplary.getPublishedDate());
		exemplaryDTO.setCode(exemplary.getCode());
		exemplaryDTO.setPageNumbers(exemplary.getPageNumbers());
		exemplaryDTO.setLanguage(exemplary.getLanguage());
		return exemplaryDTO;
	}

	public List<ExemplaryDTO> exemplaryList2ExemplaryDTOList(List<Exemplary> exemplaryList) {
		return exemplaryList.stream().map(exemplary -> exemplary2ExemplaryDTO(exemplary)).collect(Collectors.toList());
	}

	public Exemplary exemplaryDTO2Exemplary(ExemplaryDTO exemplaryDTO) {
		Exemplary exemplary = new Exemplary();
		exemplary.setId(exemplaryDTO.getId());
		exemplary.setPublishedDate(exemplaryDTO.getPublishedDate());
		exemplary.setCode(exemplaryDTO.getCode());
		exemplary.setPageNumbers(exemplaryDTO.getPageNumbers());
		exemplary.setLanguage(exemplaryDTO.getLanguage());
		return exemplary;
	}

	public List<ExemplaryDTO> exemplaryList2Exemplary(List<Exemplary> exemplaries) {
		return exemplaries.stream().map(this::exemplary2ExemplaryDTO).collect(Collectors.toList());
	}
}
