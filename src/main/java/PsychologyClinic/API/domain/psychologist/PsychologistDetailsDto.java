package PsychologyClinic.API.domain.psychologist;

import PsychologyClinic.API.domain.address.Address;

public record PsychologistDetailsDto(Long id, String firstName, String lastName, String email, String crp, Specialty specialty, Address address) {


    public PsychologistDetailsDto(Psychologist psychologist) {
        this(psychologist.getId(), psychologist.getFirstName(), psychologist.getLastName(), psychologist.getEmail(), psychologist.getCrp(), psychologist.getSpecialty(), psychologist.getAddress());
    }

}
