package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;

import java.util.stream.Collectors;

public final class AddressMapper
{
    private static DoctorMapper doctorMapper;
    private static PatientMapper patientMapper;


    public static AddressTO mapToTO(final AddressEntity addressEntity)
    {
        if (addressEntity == null)
        {
            return null;
        }
        final AddressTO addressTO = new AddressTO();
        addressTO.setId(addressEntity.getId());
        addressTO.setAddressLine1(addressEntity.getAddressLine1());
        addressTO.setAddressLine2(addressEntity.getAddressLine2());
        addressTO.setCity(addressEntity.getCity());
        addressTO.setPostalCode(addressEntity.getPostalCode());

        addressTO.setDoctors(addressEntity.getDoctors().stream()
                .map(DoctorMapper::mapToTO)
                .collect(Collectors.toList()));

        addressTO.setPatients(addressEntity.getPatients().stream()
                .map(PatientMapper::mapToTO)
                .collect(Collectors.toList()));

        return addressTO;
    }

    public static AddressEntity mapToEntity(final AddressTO addressTO)
    {
        if(addressTO == null)
        {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressTO.getId());
        addressEntity.setAddressLine1(addressTO.getAddressLine1());
        addressEntity.setAddressLine2(addressTO.getAddressLine2());
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setPostalCode(addressTO.getPostalCode());
        return addressEntity;
    }
}
