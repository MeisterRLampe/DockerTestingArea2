package com.meisterlampe.dockertestingarea2.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Ausleihe", schema = "bookstorefinal")
public class Ausleihe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idbookorder")
    private int idbookorder;

    @Column(name = "ausleihedatum")
    private Timestamp ausleihedatum;

    @Column(name = "rueckgabe")
    private Timestamp rueckgabe;

    @Column(name="ausleihe")
    private Timestamp ausleihe;

    @ManyToOne
    @JoinColumn(name= "stock")
    private Books stock;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idbooks")
    private Books ausgelieheneBucher;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ausleihe ausleihe1 = (Ausleihe) o;
        return idbookorder == ausleihe1.idbookorder && Objects.equals(ausleihedatum, ausleihe1.ausleihedatum) && Objects.equals(rueckgabe, ausleihe1.rueckgabe) && Objects.equals(ausleihe, ausleihe1.ausleihe) && Objects.equals(stock, ausleihe1.stock) && Objects.equals(user, ausleihe1.user) && Objects.equals(ausgelieheneBucher, ausleihe1.ausgelieheneBucher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idbookorder, ausleihedatum, rueckgabe, ausleihe, stock, user, ausgelieheneBucher);
    }
}
