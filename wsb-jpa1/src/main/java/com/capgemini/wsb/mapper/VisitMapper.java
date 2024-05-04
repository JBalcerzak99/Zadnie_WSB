package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper {

    private DoctorMapper doctorMapper;
    private PatientMapper patientMapper;
    private MedicalTreatmentMapper medicalTreatmentMapper;
    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        if (visitEntity.getDoctor() != null) {
            visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        }

        if (visitEntity.getPatient() != null) {
            visitTO.setPatient(PatientMapper.mapToTO(visitEntity.getPatient()));
        }

        if (visitEntity.getMedicalTreatment() != null) {
            visitTO.setMedicalTreatment(MedicalTreatmentMapper.mapToTO(visitEntity.getMedicalTreatment()));
        }

        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO)
    {
        if(visitTO == null)
        {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        return visitEntity;
    }
}
