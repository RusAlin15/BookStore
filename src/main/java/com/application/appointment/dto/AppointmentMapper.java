package com.application.appointment.dto;

import org.springframework.stereotype.Component;

import com.application.appointment.Appointment;

@Component
public class AppointmentMapper {

	public Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();

		appointment.setId(appointmentDTO.getId());
		appointment.setStartDate(appointmentDTO.getStartDate());
		appointment.setEndDate(appointmentDTO.getEndDate());
		return appointment;
	}

	public AppointmentDTO appointmentToAppointmentDTO(Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();

		appointmentDTO.setId(appointment.getId());
		appointmentDTO.setStartDate(appointment.getStartDate());
		appointmentDTO.setEndDate(appointment.getEndDate());
		return appointmentDTO;
	}

}
