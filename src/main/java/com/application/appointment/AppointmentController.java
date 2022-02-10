package com.application.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.appointment.dto.AppointmentDTO;
import com.application.appointment.dto.AppointmentMapper;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;

//	@GetMapping("/find-free")
//	@ResponseBody
//	public ResponseEntity<Set<AppointmentDTO>> getFreeBooks(@RequestParam LocalDate startDate,
//			@RequestParam LocalDate endDate) {
//
//	}

	@PostMapping("/{userId}/{exemplaryId}")
	public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO,
			@PathVariable Integer userId, @PathVariable Integer exemplaryId) {

		Appointment appointment = appointmentMapper.appointmentDTOToAppointment(appointmentDTO);

		return new ResponseEntity<AppointmentDTO>(appointmentMapper.appointmentToAppointmentDTO(
				appointmentService.createAppointment(appointment, userId, exemplaryId)), HttpStatus.OK);
	}

}
