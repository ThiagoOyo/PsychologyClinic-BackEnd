package PsychologyClinic.API.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String district;
    private String cep;
    private String addressNumber;
    private String city;
    private String complement;
    private String uf;

    public Address(PostAddressData address) {
        this.street = address.street();
        this.district = address.district();
        this.cep = address.cep();
        this.uf = address.uf();
        this.city = address.city();
        this.addressNumber = address.addressNumber();
        this.complement = address.complement();
    }

    public void updateAddressInfo(PostAddressData addressData) {
        if (addressData.street() != null) {
            this.street = addressData.street();
        }
        if (addressData.district() != null) {
            this.district = addressData.district();
        }
        if (addressData.cep() != null) {
            this.cep = addressData.cep();
        }
        if (addressData.addressNumber() != null) {
            this.addressNumber = addressData.addressNumber();
        }
        if(addressData.city() != null) {
            this.city = addressData.city();
        }
        if (addressData.complement() != null) {
            this.complement = addressData.complement();
        }
        if (addressData.uf() != null) {
            this.uf = addressData.uf();
        }
    }
}
