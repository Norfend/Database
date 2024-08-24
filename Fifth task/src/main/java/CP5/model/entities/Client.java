package CP5.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Clients\"")
public class Client extends Person {
    @Basic(fetch = FetchType.EAGER)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"client_ID\"", insertable = false, updatable = false)
    private long clientId;

    @ColumnDefault("0")
    @Column(name = "\"loyaltyPoints\"")
    private Integer loyaltyPoints;

    @OneToMany(mappedBy = "owner")
    private Set<Car> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "payer")
    private Set<Order> orders = new LinkedHashSet<>();

    public long getClientId() {
        return clientId;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}