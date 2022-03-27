package com.application.appointment;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.appointment.dto.AppointmentCreateDto;
import com.application.appointment.dto.AppointmentDto;
import com.application.appointment.dto.AppointmentMapper;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;

	@PostMapping
	public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentCreateDto appointmentDto) {
		Appointment appointment = appointmentMapper.appointmentDto2Appointment(appointmentDto);
		return new ResponseEntity<AppointmentDto>(appointmentMapper.appointment2AppointmentDto(appointmentService
				.createAppointment(appointment, appointmentDto.getUserId(), appointmentDto.getExemplaryId())),
				HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<AppointmentDto>> getAppointments() {
		return new ResponseEntity<List<AppointmentDto>>(
				appointmentMapper.appointmentList2AppointmentDtoList(appointmentService.getAppointments()),
				HttpStatus.OK);
	}

	public ResponseEntity<FileNotFoundException> handleException(FileNotFoundException exception) {
		return new ResponseEntity<FileNotFoundException>(exception, HttpStatus.NOT_FOUND);
	}
}
