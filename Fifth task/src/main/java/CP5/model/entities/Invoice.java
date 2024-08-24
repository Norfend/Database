package CP5.model.entities;

import CP5.model.references.InvoiceHasItem;
import CP5.model.types.InvoiceId;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Invoice\"", schema = "public")
public class Invoice {
    @EmbeddedId
    private InvoiceId id;

    @MapsId("orderNumber")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"orderNumber\"", nullable = false)
    private Order orderNumber;

    @Column(name = "\"totalCost\"", nullable = false)
    private BigDecimal totalCost;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceHasItem> invoiceHasItems = new LinkedHashSet<>();

    public InvoiceId getId() {
        return id;
    }

    public void setId(InvoiceId id) {
        this.id = id;
    }

    public Order getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Order orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Set<InvoiceHasItem> getInvoiceHasItems() {
        return invoiceHasItems;
    }

    public void setInvoiceHasItems(Set<InvoiceHasItem> invoiceHasItems) {
        this.invoiceHasItems = invoiceHasItems;
    }

}