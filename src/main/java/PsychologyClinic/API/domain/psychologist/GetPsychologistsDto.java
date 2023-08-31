package PsychologyClinic.API.domain.psychologist;

public record GetPsychologistsDto(Long id, String firstName, String lastName, String crp, Specialty specialty ) {

    public GetPsychologistsDto(Psychologist psychologist) {
        this (psychologist.getId(), psychologist.getFirstName(), psychologist.getLastName(), psychologist.getCrp(), psychologist.getSpecialty());
    }

}
