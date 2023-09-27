package com.meisterlampe.dockertestingarea2.entites;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "book_order", schema = "bookstore", catalog = "")
public class BookOrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idorder")
    private int idorder;
    @Basic
    @Column(name = "idcustomer")
    private Integer idcustomer;
    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Basic
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    @Basic
    @Column(name = "order_version")
    private Long orderVersion;

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public Integer getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Integer idcustomer) {
        this.idcustomer = idcustomer;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookOrderEntity that = (BookOrderEntity) o;

        if (idorder != that.idorder) return false;
        if (idcustomer != null ? !idcustomer.equals(that.idcustomer) : that.idcustomer != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(that.lastModifiedDate) : that.lastModifiedDate != null)
            return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idorder;
        result = 31 * result + (idcustomer != null ? idcustomer.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }

    public Long getOrderVersion() {
        return orderVersion;
    }

    public void setOrderVersion(Long orderVersion) {
        this.orderVersion = orderVersion;
    }
}
