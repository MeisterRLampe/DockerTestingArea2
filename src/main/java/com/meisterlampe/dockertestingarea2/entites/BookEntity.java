package com.meisterlampe.dockertestingarea2.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Entity
@Setter
@Table(name = "books", schema = "bookstore", catalog = "")
public class BookEntity {
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idbooks")
    private int idbooks;
    @Basic
    @Column(name = "booktitle")
    private String bookTitle;
    @Basic
    @Column(name = "pages")
    private String pages;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "book_version")
    private Integer bookVersion;
    @Basic
    @Column(name = "releaseDate")
    private Date releaseDate;

    @Basic
    @Column(name= "bookentry")
    private String bookEntry;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity bookEntity = (BookEntity) o;

        if (idbooks != bookEntity.idbooks) return false;
        if (bookTitle != null ? !bookTitle.equals(bookEntity.bookTitle) : bookEntity.bookTitle != null) return false;
        if (pages != null ? !pages.equals(bookEntity.pages) : bookEntity.pages != null) return false;
        if (price != null ? !price.equals(bookEntity.price) : bookEntity.price != null) return false;
        if (bookVersion != null ? !bookVersion.equals(bookEntity.bookVersion) : bookEntity.bookVersion != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(bookEntity.releaseDate) : bookEntity.releaseDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbooks;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (bookVersion != null ? bookVersion.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "idbooks=" + idbooks +
                ", bookTitle='" + bookTitle + '\'' +
                ", pages='" + pages + '\'' +
                ", price=" + price +
                ", bookVersion=" + bookVersion +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
