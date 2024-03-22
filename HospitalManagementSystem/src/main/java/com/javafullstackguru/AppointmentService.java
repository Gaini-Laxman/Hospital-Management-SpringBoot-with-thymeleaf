package com.javafullstackguru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<Appointment> listAll() {
		return appointmentRepository.findAll();
	}

	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	public void delete(Integer id) {
		appointmentRepository.deleteById(id);
	}

	public int setConfirmation(String confirmation, Integer id) {
		return appointmentRepository.setConfirmation(confirmation, id);
	}

	public int setPrescription(String prescription, Integer id) {
		return appointmentRepository.setPrescription(prescription, id);
	}

	public Optional<Appointment> get(Integer id) {
		return appointmentRepository.findById(id);
	}

	public List<Appointment> findByPatientName(String patientName) {
		return appointmentRepository.findByPatientName(patientName);
	}

	public List<Appointment> findByDoctorName(String doctorName) {
		return appointmentRepository.findByDoctorName(doctorName);
	}

	public List<Appointment> findByDate(String date, String doctorName) {
		return appointmentRepository.findByDate(date, doctorName);
	}
}
