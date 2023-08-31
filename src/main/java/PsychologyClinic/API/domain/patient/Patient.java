package PsychologyClinic.API.domain.patient;

import PsychologyClinic.API.domain.address.Address;
import PsychologyClinic.API.domain.psychologist.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String cpf;

    @Embedded
    private Address address;

    public Patient(PostPatientDto data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.cellphone = data.cellphone();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }

    public void updatePatientInfo(PutPatientDto data) {
        if (data.cellphone() != null) {
            this.cellphone = data.cellphone();
        }
        if (data.firstName() != null) {
            this.firstName = data.firstName();
        }
        if (data.lastName() != null) {
            this.lastName = data.lastName();
        }
        if (data.address() != null) {
            this.address.updateAddressInfo(data.address());
        }
    }
}
