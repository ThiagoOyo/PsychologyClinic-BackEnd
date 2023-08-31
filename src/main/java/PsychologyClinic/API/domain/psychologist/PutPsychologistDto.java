package PsychologyClinic.API.domain.psychologist;

import PsychologyClinic.API.domain.address.PostAddressData;
import jakarta.validation.constraints.NotNull;

public record PutPsychologistDto(
        @NotNull
        Long id,

        String firstName,
        String lastName,
        String cellphone,
        PostAddressData address) {
}
