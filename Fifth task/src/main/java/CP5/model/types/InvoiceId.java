package CP5.model.types;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class InvoiceId {
    @Column(name = "\"orderNumber\"", nullable = false)
    private Long orderNumber;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Invoice_number_seq\"")
    @SequenceGenerator(name = "\"Invoice_number_seq\"", sequenceName = "\"Invoice_number_seq\"", allocationSize = 1)
    @Column(name = "number", nullable = false)
    private Long number;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvoiceId entity = (InvoiceId) o;
        return Objects.equals(this.number, entity.number) &&
                Objects.equals(this.orderNumber, entity.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, orderNumber);
    }

}