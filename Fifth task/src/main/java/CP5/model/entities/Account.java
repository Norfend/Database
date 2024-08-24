package CP5.model.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Accounts\"", schema = "public")
public class Account {
    @Id
    @Column(name = "login", nullable = false, length = Integer.MAX_VALUE)
    private String login;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Person person;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}