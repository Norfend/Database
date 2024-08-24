package CP5.model;

import CP5.model.entities.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"orderOperations\"", schema = "public")
public class OrderOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderOperations_id_gen")
    @SequenceGenerator(name = "orderOperations_id_gen", sequenceName = "orderOperations_NMID_seq", allocationSize = 1)
    @Column(name = "\"NMID\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"orderNumber\"", nullable = false)
    private Order orderNumber;

    @Column(name = "operation", nullable = false, length = Integer.MAX_VALUE)
    private String operation;

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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}