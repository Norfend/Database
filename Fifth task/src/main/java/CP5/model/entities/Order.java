package CP5.model.entities;

import CP5.model.references.OrderContainOrderItem;
import CP5.model.types.AddressConverter;
import CP5.model.types.OrderDate;
import CP5.model.OrderOperation;
import CP5.model.references.Worker;
import CP5.model.types.OrderDateConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Orders\"", schema = "public")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orders_id_gen")
    @SequenceGenerator(name = "Orders_id_gen", sequenceName = "Orders_orderNumber_seq", allocationSize = 1)
    @Column(name = "\"orderNumber\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @ColumnDefault("'-1'::bigint")
    @JoinColumn(name = "payer", referencedColumnName = "\"client_ID\"", nullable = false)
    private Client payer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject")
    private Car subject;

    @Column(nullable = false)
    @Convert(converter = OrderDateConverter.class)
    private OrderDate date;

    @OneToMany(mappedBy = "orderNumber")
    private Set<Invoice> invoices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "orderNumber")
    private Set<OrderContainOrderItem> orderContainOrderItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "orderNumber")
    private Set<OrderOperation> orderOperations = new LinkedHashSet<>();
    @OneToMany(mappedBy = "orderNumber")
    private Set<Worker> workers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getPayer() {
        return payer;
    }

    public void setPayer(Client payer) {
        this.payer = payer;
    }

    public Car getSubject() {
        return subject;
    }

    public void setSubject(Car subject) {
        this.subject = subject;
    }

    public OrderDate getDate() {
        return date;
    }

    public void setDate(OrderDate date) {
        this.date = date;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<OrderContainOrderItem> getOrderContainOrderItems() {
        return orderContainOrderItems;
    }

    public void setOrderContainOrderItems(Set<OrderContainOrderItem> orderContainOrderItems) {
        this.orderContainOrderItems = orderContainOrderItems;
    }

    public Set<OrderOperation> getOrderOperations() {
        return orderOperations;
    }

    public void setOrderOperations(Set<OrderOperation> orderOperations) {
        this.orderOperations = orderOperations;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}