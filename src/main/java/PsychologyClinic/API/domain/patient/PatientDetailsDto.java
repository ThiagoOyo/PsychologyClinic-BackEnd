package PsychologyClinic.API.domain.patient;

import PsychologyClinic.API.domain.address.Address;

public record PatientDetailsDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String cpf,
        Address address
) {

    public PatientDetailsDto(Patient patient) {
        this(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getEmail(), patient.getCpf(), patient.getAddress());
    }


}
