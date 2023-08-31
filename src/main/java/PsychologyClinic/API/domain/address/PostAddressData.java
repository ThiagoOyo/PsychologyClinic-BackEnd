package PsychologyClinic.API.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PostAddressData(
        @NotBlank
        String street,
        String addressNumber,
        @NotBlank
        String city,
        @NotBlank
        String district,
        @NotBlank
         @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String uf,
        String complement) {

}
