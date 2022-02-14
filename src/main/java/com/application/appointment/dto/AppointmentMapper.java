package com.application.appointment.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.appointment.Appointment;
import com.application.exemplary.dto.ExemplaryMapper;

@Component
public class AppointmentMapper {
	@Autowired
	ExemplaryMapper exemplaryMapper;

	public Appointment appointmentDto2Appointment(AppointmentCreateDto appointmentDto) {
		Appointment appointment = new Appointment();

		appointment.setId(appointmentDto.getId());
		appointment.setStartDate(appointmentDto.getStartDate());
		appointment.setEndDate(appointmentDto.getEndDate());
		return appointment;
	}

	public AppointmentDto appointment2AppointmentDto(Appointment appointment) {
		AppointmentDto appointmentDto = new AppointmentDto();

		appointmentDto.setId(appointment.getId());
		appointmentDto.setStartDate(appointment.getStartDate());
		appointmentDto.setEndDate(appointment.getEndDate());
		appointmentDto.setExemplaryDto(exemplaryMapper.exemplary2ExemplaryDto(appointment.getExemplary()));
		return appointmentDto;
	}

	public List<AppointmentDto> appointmentList2AppointmentDtoList(List<Appointment> appointments) {
		return appointments.stream().map(this::appointment2AppointmentDto).collect(Collectors.toList());
	}

}
