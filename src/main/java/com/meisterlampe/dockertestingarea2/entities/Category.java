package com.meisterlampe.dockertestingarea2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Category", schema = "bookstorefinal")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategory")
    private int idcategory;
    @Getter
    @Basic

    @Column(name = "categoryname")
    private String categoryname;



    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (idcategory != category.idcategory) return false;
        if (categoryname != null ? !categoryname.equals(category.categoryname) : category.categoryname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (categoryname != null ? categoryname.hashCode() : 0);
        return result;
    }
}
