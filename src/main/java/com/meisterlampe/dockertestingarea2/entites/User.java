package com.meisterlampe.dockertestingarea2.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser")
    private int iduser;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "zipcode")
    private String zipcode;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "dob")
    private Date dob;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Ausleihe> ausgelieheneBucher = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (iduser != user.iduser) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (zipcode != null ? !zipcode.equals(user.zipcode) : user.zipcode != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (dob != null ? !dob.equals(user.dob) : user.dob != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
