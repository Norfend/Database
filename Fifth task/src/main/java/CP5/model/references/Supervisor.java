package CP5.model.references;

import CP5.model.entities.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "supervisor", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "supervisorunique", columnNames = {"employee"})
})
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supervisor_id_gen")
    @SequenceGenerator(name = "supervisor_id_gen", sequenceName = "supervisor_NMID_seq", allocationSize = 1)
    @Column(name = "\"NMID\"", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee", referencedColumnName = "\"employee_ID\"")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supervisor", referencedColumnName = "\"employee_ID\"")
    private Employee supervisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

}