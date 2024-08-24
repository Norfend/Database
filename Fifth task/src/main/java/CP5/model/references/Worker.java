package CP5.model.references;

import CP5.model.entities.Employee;
import CP5.model.entities.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "worker", schema = "public")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_id_gen")
    @SequenceGenerator(name = "worker_id_gen", sequenceName = "worker_NMID_seq", allocationSize = 1)
    @Column(name = "\"NMID\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @ColumnDefault("'-1'::bigint")
    @JoinColumn(name = "employee_ID", referencedColumnName = "\"employee_ID\"")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"orderNumber\"")
    private Order orderNumber;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}