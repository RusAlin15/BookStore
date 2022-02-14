package com.application.appointment.dto;

import java.time.LocalDate;

import com.application.exemplary.dto.ExemplaryDto;

public class AppointmentDto {
	private Integer Id;
	private LocalDate startDate;
	private LocalDate endDate;
	private ExemplaryDto exemplaryDto;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ExemplaryDto getExemplaryDto() {
		return exemplaryDto;
	}

	public void setExemplaryDto(ExemplaryDto exemplaryDto) {
		this.exemplaryDto = exemplaryDto;
	}

}
