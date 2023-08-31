package PsychologyClinic.API.domain.psychologist;

import PsychologyClinic.API.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "psychologists")
@Entity(name = "Psychologist")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Psychologist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String crp;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;
    private Boolean active;

    public Psychologist(PostPsychologistDto data) {
        this.active = true;

        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.cellphone = data.cellphone();
        this.crp = data.crp();
        this.specialty = data.specialty();
        this.address = new Address(data.address());

    }

    public void updatePsychologistInfo(PutPsychologistDto data) {

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

    public void remove() {

        this.active = false;
    }
}
