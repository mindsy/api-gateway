package br.com.mindsy.api.gateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "MINDSY", name = "PSYCHOLOGISTS")
public class PsychologistEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crp")
    private String crp;

    @Column(name = "dt_birth")
    private Date birthDate;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "fk_person")
    private Long person;

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

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }
}
