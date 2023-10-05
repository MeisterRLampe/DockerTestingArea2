package com.meisterlampe.dockertestingarea2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "books", schema = "bookstorefinal")
public class Books {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idbooks")
    private int idbooks;
    @Column(name = "booktitle")
    private String booktitle;
    @Column(name = "pages")
    private String pages;
    @Column(name = "price")
    private String price;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "bookentry")
    private String bookentry;





    @Column(name = "idcategory", insertable = false, updatable = false)
    private Integer idcategory;

    @ManyToOne
    @JoinColumn(name="idcategory")
    private Category category;


    @OneToMany(mappedBy = "ausgelieheneBucher")
    private List<Ausleihe> ausleihe;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (idbooks != books.idbooks) return false;
        if (booktitle != null ? !booktitle.equals(books.booktitle) : books.booktitle != null) return false;
        if (pages != null ? !pages.equals(books.pages) : books.pages != null) return false;
        if (price != null ? !price.equals(books.price) : books.price != null) return false;
        if (releaseDate != null ? !releaseDate.equals(books.releaseDate) : books.releaseDate != null) return false;
        if (bookentry != null ? !bookentry.equals(books.bookentry) : books.bookentry != null) return false;
        if (idcategory != null ? !idcategory.equals(books.idcategory) : books.idcategory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbooks;
        result = 31 * result + (booktitle != null ? booktitle.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (bookentry != null ? bookentry.hashCode() : 0);
        result = 31 * result + (idcategory != null ? idcategory.hashCode() : 0);
        return result;
    }
}
