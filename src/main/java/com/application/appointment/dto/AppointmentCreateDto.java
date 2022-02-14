package com.application.appointment.dto;

import java.time.LocalDate;

public class AppointmentCreateDto {

	private Integer Id;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer userId;
	private Integer exemplaryId;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getExemplaryId() {
		return exemplaryId;
	}

	public void setExemplaryId(Integer exemplaryId) {
		this.exemplaryId = exemplaryId;
	}

}
