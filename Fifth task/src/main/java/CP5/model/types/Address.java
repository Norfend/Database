package CP5.model.types;

import java.io.Serializable;

public class Address {
    private String city;
    private String street;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return city.equals(address.city) && street.equals(address.street);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return city + "," + street;
    }
}
