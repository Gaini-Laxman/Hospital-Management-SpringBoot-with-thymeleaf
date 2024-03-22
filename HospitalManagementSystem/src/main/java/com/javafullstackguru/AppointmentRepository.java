package com.javafullstackguru;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByDoctorName(String doctorName);

	List<Appointment> findByPatientName(String patientName);

	@Modifying
	@Transactional
	@Query("update Appointment a set a.confirmed = ?1 where a.appointmentId = ?2")
	int setConfirmation(String confirmation, Integer id);

	@Modifying
	@Transactional
	@Query("update Appointment a set a.prescription = ?1 where a.appointmentId = ?2")
	int setPrescription(String prescription, Integer id);

	@Query(value = "select * from appointment a where a.appointment_date = ?1 AND a.doctor_name = ?2", nativeQuery = true)
	List<Appointment> findByDate(String date, String doctorName);
}
