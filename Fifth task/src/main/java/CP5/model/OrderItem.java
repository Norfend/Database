package CP5.model;

import CP5.model.references.OrderContainOrderItem;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"orderItems\"", schema = "public")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItems_id_gen")
    @SequenceGenerator(name = "orderItems_id_gen", sequenceName = "orderItems_orderItem_ID_seq", allocationSize = 1)
    @Column(name = "\"orderItem_ID\"", nullable = false)
    private Long id;

    @Column(name = "item", nullable = false, length = Integer.MAX_VALUE)
    private String item;

    @OneToMany(mappedBy = "orderItem")
    private Set<OrderContainOrderItem> orderContainOrderItems = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Set<OrderContainOrderItem> getOrderContainOrderItems() {
        return orderContainOrderItems;
    }

    public void setOrderContainOrderItems(Set<OrderContainOrderItem> orderContainOrderItems) {
        this.orderContainOrderItems = orderContainOrderItems;
    }

}