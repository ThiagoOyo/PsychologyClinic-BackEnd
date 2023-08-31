package PsychologyClinic.API.domain.psychologist;

import PsychologyClinic.API.domain.address.PostAddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PostPsychologistDto(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cellphone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crp,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        PostAddressData address) {
}
