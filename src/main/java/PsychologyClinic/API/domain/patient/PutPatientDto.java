package PsychologyClinic.API.domain.patient;

import PsychologyClinic.API.domain.address.PostAddressData;
import jakarta.validation.constraints.NotNull;

public record PutPatientDto(
        @NotNull
        Long id,
        String firstName,
        String lastName,
        String cellphone,
        PostAddressData address)
{

}
