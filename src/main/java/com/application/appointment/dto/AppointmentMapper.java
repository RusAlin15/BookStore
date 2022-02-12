package com.application.appointment.dto;

import org.springframework.stereotype.Component;

import com.application.appointment.Appointment;

@Component
public class AppointmentMapper {

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
		return appointmentDto;
	}

}
