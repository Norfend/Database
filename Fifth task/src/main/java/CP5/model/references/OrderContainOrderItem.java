package CP5.model.references;

import CP5.model.OrderItem;
import CP5.model.entities.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"Order contain orderItems\"", schema = "public")
public class OrderContainOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order_contain_orderItems_id_gen")
    @SequenceGenerator(name = "Order_contain_orderItems_id_gen", sequenceName = "Order contain orderItems_NMID_seq", allocationSize = 1)
    @Column(name = "\"NMID\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"orderNumber\"", nullable = false)
    private Order orderNumber;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"orderItem_ID\"", nullable = false)
    private OrderItem orderItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Order orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

}