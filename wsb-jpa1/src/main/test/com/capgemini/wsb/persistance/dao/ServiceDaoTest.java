package com.capgemini.wsb.persistance.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.repository.DoctorRepository;
import com.capgemini.wsb.persistence.repository.PatientRepository;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    @Test
    public void testShouldRemovePatientAndAllVisits() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("john.doe@example.com");
        patientEntity.setPatientNumber("PN12345");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
        // Additional field
        patientEntity.setAdditionalField("Some additional info");

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName("Alice");
        doctorEntity.setLastName("Smith");
        doctorEntity.setTelephoneNumber("987654321");
        doctorEntity.setEmail("alice.smith@example.com");
        doctorEntity.setDoctorNumber("DN67890");
        doctorEntity.setSpecialization(Specialization.GP);

        doctorRepository.save(doctorEntity);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription("Regular checkup");
        visitEntity.setTime(LocalDateTime.of(2024, 5, 3, 10, 0));
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setPatient(patientEntity);

        patientEntity.getVisits().add(visitEntity);

        patientRepository.save(patientEntity);

        // when
        patientService.removePatientById(patientEntity.getId());

        // then
        assertThat(patientRepository.findOne(patientEntity.getId())).isNull();
        assertThat(visitRepository.findByPatientId(patientEntity.getId())).isEmpty();
        assertThat(doctorRepository.findOne(doctorEntity.getId())).isNotNull();
    }

    @Transactional
    @Test
    public void testShouldGetPatientById() {
        // given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Jacek");
        patientEntity.setLastName("Pacek");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("jacek.pacek@example.com");
        patientEntity.setPatientNumber("PN54321");
        patientEntity.setDateOfBirth(LocalDate.of(1985, 5, 15));
        // Additional field
        patientEntity.setAdditionalField("Some additional info");

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName("Jan");
        doctorEntity.setLastName("Kowalski");
        doctorEntity.setTelephoneNumber("987654321");
        doctorEntity.setEmail("jan.kowalski@example.com");
        doctorEntity.setDoctorNumber("DN98765");
        doctorEntity.setSpecialization(Specialization.DERMATOLOGIST);

        doctorRepository.save(doctorEntity);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription("Dermatology appointment");
        visitEntity.setTime(LocalDateTime.of(2024, 6, 5, 14, 30));
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setPatient(patientEntity);

        patientEntity.getVisits().add(visitEntity);

        patientRepository.save(patientEntity);

        // when
        PatientTO patientTO = patientService.findById(patientEntity.getId());

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo("Jacek");
        assertThat(patientTO.getLastName()).isEqualTo("Pacek");
        assertThat(patientTO.getAdditionalField()).isEqualTo("Some additional info");

        List<VisitTO> visits = patientTO.getVisits();
        assertThat(visits).isNotEmpty();
        assertThat(visits.get(0).getDescription()).isEqualTo("Dermatology appointment");
        assertThat(visits.get(0).getDoctor().getFirstName()).isEqualTo("Jan");
        assertThat(visits.get(0).getDoctor().getLastName()).isEqualTo("Kowalski");
    }
}
