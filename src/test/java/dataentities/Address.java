package dataentities;

import lombok.Data;

@Data
public class Address {

    private String street;
    private int houseNumber;
    private int zipCode;
    private String city;

    public Address() {
    }

    public Address(String street, int houseNumber, int zipCode, String city) {

        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


}
