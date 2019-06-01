package br.com.mindsy.api.gateway.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PSYCHOLOGIST")
public class PsychologistEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crp")
    private String crp;

    @Column(name = "dt_birth", nullable = false)
    private Date birthDate;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token")
    private String token;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_person", unique = true, nullable = false)
    private PersonEntity person;

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
