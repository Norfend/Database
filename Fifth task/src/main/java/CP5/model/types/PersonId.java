package CP5.model.types;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PersonId {
    @Column(name = "\"firstName\"", nullable = false, length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "\"secondName\"", nullable = false, length = Integer.MAX_VALUE)
    private String secondName;

    public PersonId() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonId entity = (PersonId) o;
        return Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.secondName, entity.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName;
    }
}