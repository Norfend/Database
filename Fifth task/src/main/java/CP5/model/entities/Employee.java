package CP5.model.entities;

import CP5.model.references.Supervisor;
import CP5.model.references.Worker;
import CP5.model.types.Address;
import CP5.model.types.AddressConverter;
//import CP5.model.types.AddressUserType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Employees\"")
public class Employee extends Person {
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Employees_employee_ID_seq\"")
    @SequenceGenerator(name = "\"Employees_employee_ID_seq\"", sequenceName = "\"Employees_employee_ID_seq\"", allocationSize = 1)
    @Column(name = "\"employee_ID\"", updatable = false, insertable = false)
    private long employeeID;

    @Column(name = "salary")
    private Integer salary;

    @Convert(converter = AddressConverter.class)
    @Column(name = "address")
    private Address address;

    @OneToOne(mappedBy = "employee")
    private Supervisor supervisor;

    @OneToMany(mappedBy = "supervisor")
    private Set<Supervisor> supervisors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Worker> workers = new LinkedHashSet<>();

    public long getEmployeeID() {
        return employeeID;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Set<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Set<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

}