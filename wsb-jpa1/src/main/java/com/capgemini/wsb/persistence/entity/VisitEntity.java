package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name ="DESCRIPTION", nullable = false)
	private String description;

	@Column(name ="TIME",nullable = false)
	private LocalDateTime time;

	@ManyToOne
	@JoinColumn(name = "medical_treatment_id")
	private MedicalTreatmentEntity medicalTreatment;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private PatientEntity doctor;

	public void setDoctor(PatientEntity doctor) {
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public MedicalTreatmentEntity getMedicalTreatment() {
		return medicalTreatment;
	}

	public void setMedicalTreatment(MedicalTreatmentEntity medicalTreatment) {
		this.medicalTreatment = medicalTreatment;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return null;
	}
}
