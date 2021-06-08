package pet_shop;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {

    @Column(name = "N°")
    private String number;
    @Column(name = "RUE")
    private String street;
    @Column(name = "CP")
    private String zipCode;
    @Column(name = "VILLE")
    private String city;

    public Adresse(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Adresse(String number, String street) {
        this.number = number;
        this.street = street;
    }

    public Adresse() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
