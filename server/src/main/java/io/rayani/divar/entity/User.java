package io.rayani.divar.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @Pattern( regexp = "^[A-Za-z ]+")
    private String firstName;
    @Pattern( regexp = "^[A-Za-z ]+")
    @Column(nullable = false)
    private String lastName;
    @Email
    @Column(unique = true,updatable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String doublePassword;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
    private Province province;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmil() {
        return email;
    }

    public void setEmil(String emil) {
        this.email = emil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDoublePassword() {
        return doublePassword;
    }

    public void setDoublePassword(String doublePassword) {
        this.doublePassword = doublePassword;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
