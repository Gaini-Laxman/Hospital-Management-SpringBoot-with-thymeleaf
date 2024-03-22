package com.javafullstackguru;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "prescription", schema = "hospital")
@DynamicUpdate
public class Invoice {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceID;

	@Column
	private String patientName;

	@Column
	private Integer appointmentID;

	@Column
	private String invoice;

	// Constructors
	public Invoice() {}

	public Invoice(Integer invoiceID, String patientName, Integer appointmentID, String invoice) {
		this.invoiceID = invoiceID;
		this.patientName = patientName;
		this.appointmentID = appointmentID;
		this.invoice = invoice;
	}

	// Getters and Setters
	public Integer getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(Integer appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
}
