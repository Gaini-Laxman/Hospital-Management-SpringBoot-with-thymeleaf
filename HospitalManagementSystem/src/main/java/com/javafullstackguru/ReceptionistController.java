package com.javafullstackguru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	private AppointmentService service;

	@GetMapping("/receptionistAppointments")
	public String showReceptionistAppointments(Model model) {
		List<Appointment> listAppointments = service.listAll();
		model.addAttribute("listAppointments", listAppointments);

		String confirmed = "confirmed";
		model.addAttribute("confirmed", confirmed);
		return "receptionistAppointments";
	}

	@GetMapping("/confirmm")
	public String showConfirmm(Model model) {
		Appointment confirmation = new Appointment();
		model.addAttribute("confirmation", confirmation);
		return "confirm";
	}

	@Autowired
	private EventJpaRepository repository;

	@RequestMapping(value = "/receptionistSchedule", method = RequestMethod.GET)
	public String receptionistSchedule(Model model) {
		List<Event> events = repository.findAll();
		model.addAttribute("events", events);
		return "receptionistSchedule";
	}

	@RequestMapping("/findbystart")
	public String showBydate(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);
		List<Event> event = repository.findByStart(now);
		model.addAttribute("event", event);
		return "scheduleFindByName";
	}

	@RequestMapping("/createInvoice")
	public String createInvoice(Model model) {
		Invoice invoice = new Invoice();
		model.addAttribute("invoice", invoice);
		return "invoice";
	}
}
