package com.javafullstackguru;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
	List<Prescription> findByPatientName(String patientName);
}
