package com.meisterlampe.dockertestingarea2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book_order", schema = "bookstorefinal")
public class Ausleihe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idbookorder")
    private int idbookorder;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "last_modified")
    private Timestamp lastModified;

    @Column(name="rentTime")
    private Timestamp rentTime;

    @Column(name="rent")
    private int rent;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idbooks")
    private Books ausgelieheneBucher;




    public int getIdbookorder() {
        return idbookorder;
    }

    public void setIdbookorder(int idbookorder) {
        this.idbookorder = idbookorder;
    }


    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ausleihe ausleihe = (Ausleihe) o;

        if (idbookorder != ausleihe.idbookorder) return false;
        if (createdDate != null ? !createdDate.equals(ausleihe.createdDate) : ausleihe.createdDate != null)
            return false;
        if (lastModified != null ? !lastModified.equals(ausleihe.lastModified) : ausleihe.lastModified != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbookorder;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        return result;
    }
}
