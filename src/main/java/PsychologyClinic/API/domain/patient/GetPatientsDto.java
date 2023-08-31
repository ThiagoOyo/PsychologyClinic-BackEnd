package PsychologyClinic.API.domain.patient;

public record GetPatientsDto(Long id, String firstName, String lastName, String cpf) {

    public GetPatientsDto(Patient patient) {
        this (patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getCpf());
    }
}
