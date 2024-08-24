package CP5.model.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "\"Cars\"", schema = "public")
public class Car {
    @Id
    @Column(name = "\"VIN\"", nullable = false, length = Integer.MAX_VALUE)
    private String vin;

    @Column(name = "manufacturer", nullable = false, length = Integer.MAX_VALUE)
    private String manufacturer;

    @Column(name = "model", nullable = false, length = Integer.MAX_VALUE)
    private String model;

    @Column(name = "year", nullable = false)
    private Long year;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "owner", referencedColumnName = "\"client_ID\"", nullable = false)
    private Client owner;

    @OneToMany(mappedBy = "subject")
    private Set<Order> orders = new LinkedHashSet<>();

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return vin + " " + manufacturer + " " + model;
    }
}