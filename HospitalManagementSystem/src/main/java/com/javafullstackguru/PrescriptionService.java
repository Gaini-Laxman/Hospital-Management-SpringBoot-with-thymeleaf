package com.javafullstackguru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository repository;

	public void save(Prescription prescription) {
		repository.save(prescription);
	}

	public List<Prescription> findByPatientName(String patientName) {
		return repository.findByPatientName(patientName);
	}
}
