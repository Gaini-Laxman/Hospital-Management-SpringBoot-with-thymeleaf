package com.javafullstackguru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private AppointmentService service;

	@GetMapping("/myAppointments")
	public String myAppointments(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String patientName = authentication.getName();
		List<Appointment> listAppointments = service.findByPatientName(patientName);
		model.addAttribute("listAppointments", listAppointments);
		return "myAppointments";
	}

	@GetMapping("/cancelAppointment")
	public String cancelAppointment(Model model) {
		Appointment cancelAppointment = new Appointment();
		model.addAttribute("appointment", cancelAppointment);
		return "cancelAppointment";
	}
}
