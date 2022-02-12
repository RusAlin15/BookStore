package com.application.exemplary.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.book.dto.BookMapper;
import com.application.exemplary.Exemplary;

@Component
public class ExemplaryMapper {

	@Autowired
	private BookMapper bookMapper;

	public ExemplaryDto exemplary2ExemplaryDto(Exemplary exemplary) {
		ExemplaryDto exemplaryDto = new ExemplaryDto();
		exemplaryDto.setId(exemplary.getId());
		exemplaryDto.setPublishedDate(exemplary.getPublishedDate());
		exemplaryDto.setCode(exemplary.getCode());
		exemplaryDto.setPageNumbers(exemplary.getPageNumbers());
		exemplaryDto.setLanguage(exemplary.getLanguage());
		exemplaryDto.setBookDto(bookMapper.book2ExemplaryeBookDto(exemplary.getBook()));

		return exemplaryDto;
	}

	public List<ExemplaryDto> exemplaryList2ExemplaryDtoList(List<Exemplary> exemplaryList) {
		return exemplaryList.stream().map(exemplary -> exemplary2ExemplaryDto(exemplary)).collect(Collectors.toList());
	}

	public Exemplary exemplaryCreateDto2Exemplary(ExemplaryCreateDto exemplaryCreateDto) {
		Exemplary exemplary = new Exemplary();
		exemplary.setId(exemplaryCreateDto.getId());
		exemplary.setPublishedDate(exemplaryCreateDto.getPublishedDate());
		exemplary.setCode(exemplaryCreateDto.getCode());
		exemplary.setPageNumbers(exemplaryCreateDto.getPageNumbers());
		exemplary.setLanguage(exemplaryCreateDto.getLanguage());
		return exemplary;
	}

	public List<ExemplaryDto> exemplaryList2ExemplaryDto(List<Exemplary> exemplaries) {
		return exemplaries.stream().map(this::exemplary2ExemplaryDto).collect(Collectors.toList());
	}

}
