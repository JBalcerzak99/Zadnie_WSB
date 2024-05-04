package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

import java.util.stream.Collectors;

public final class MedicalTreatmentMapper
    {
        private static VisitMapper visitMapper;

        public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity)
        {
            if (medicalTreatmentEntity == null)
            {
                return null;
            }
            final MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
            medicalTreatmentTO.setId(medicalTreatmentEntity.getId());
            medicalTreatmentTO.setDescription(medicalTreatmentEntity.getDescription());
            medicalTreatmentTO.setType(medicalTreatmentEntity.getType());

            medicalTreatmentTO.setVisits(medicalTreatmentEntity.getVisits().stream()
                    .map(VisitMapper::mapToTO)
                    .collect(Collectors.toList()));

            return medicalTreatmentTO;
        }

        public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatmentTO)
        {
            if(medicalTreatmentTO == null)
            {
                return null;
            }
            MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
            medicalTreatmentEntity.setId(MedicalTreatmentTO.getId());
            medicalTreatmentEntity.setDescription(MedicalTreatmentTO.getDescription());
            medicalTreatmentEntity.setType(MedicalTreatmentTO.getType());
            return medicalTreatmentEntity;
        }
    }

