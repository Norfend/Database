package CP5.model.entities;

import CP5.model.types.PersonId;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"Person\"", uniqueConstraints = {
        @UniqueConstraint(name = "phoneNumber", columnNames = {"\"phoneNumber\""})
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @SequenceGenerator(name = "Person_id_gen", sequenceName = "Orders_orderNumber_seq", allocationSize = 1)
    @EmbeddedId
    protected PersonId id;

    @Column(name = "\"phoneNumber\"", nullable = false, length = Integer.MAX_VALUE)
    protected String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"Accounts_login\"", nullable = false)
    protected Account accountsLogin;

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccountsLogin() {
        return accountsLogin;
    }

    public void setAccountsLogin(Account accountsLogin) {
        this.accountsLogin = accountsLogin;
    }
}