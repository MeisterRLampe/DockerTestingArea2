package com.meisterlampe.dockertestingarea2.entites;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "book_order_line", schema = "bookstore", catalog = "")
public class BookOrderLineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "idbooks")
    private Integer idbooks;
    @Basic
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;
    @Basic
    @Column(name = "order_quantity")
    private Integer orderQuantity;
    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(Integer idbooks) {
        this.idbooks = idbooks;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookOrderLineEntity that = (BookOrderLineEntity) o;

        if (id != that.id) return false;
        if (idbooks != null ? !idbooks.equals(that.idbooks) : that.idbooks != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(that.lastModifiedDate) : that.lastModifiedDate != null)
            return false;
        if (orderQuantity != null ? !orderQuantity.equals(that.orderQuantity) : that.orderQuantity != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idbooks != null ? idbooks.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        result = 31 * result + (orderQuantity != null ? orderQuantity.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
