package com.javafullstackguru;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "appointment", schema = "hospital")
@DynamicUpdate
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Integer appointmentId;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "appointment_date")
	private String date;

	@Column(name = "prescription")
	private String prescription;

	@Column(name = "confirmed")
	private String confirmed;

	// Constructors, getters, setters, and toString method
	// Constructor with all fields
	public Appointment(Integer appointmentId, String patientName, String doctorName, String date,
					   String prescription, String confirmed) {
		this.appointmentId = appointmentId;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.prescription = prescription;
		this.confirmed = confirmed;
	}

	// Default constructor
	public Appointment() {
	}

	// Getters and setters
	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	// toString method
	@Override
	public String toString() {
		return "Appointment{" +
				"appointmentId=" + appointmentId +
				", patientName='" + patientName + '\'' +
				", doctorName='" + doctorName + '\'' +
				", date='" + date + '\'' +
				", prescription='" + prescription + '\'' +
				", confirmed='" + confirmed + '\'' +
				'}';
	}
}
