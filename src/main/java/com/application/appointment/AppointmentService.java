package com.application.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exemplary.Exemplary;
import com.application.exemplary.ExemplaryService;
import com.application.user.User;
import com.application.user.UserService;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ExemplaryService exemplaryService;

	public Appointment createAppointment(Appointment appointment, Integer userId, Integer exemplaryId) {

		User user = userService.getUserById(userId);
		Exemplary exemplary = exemplaryService.getExemplaryById(exemplaryId);

		appointment.setUser(user);
		user.addAppointment(appointment);

		appointment.setExemplary(exemplary);
		exemplary.addAppointment(appointment);

		return appointmentRepository.saveAndFlush(appointment);
	}

	public List<Appointment> getAppointments() {
		return appointmentRepository.findAll();
	}

}
