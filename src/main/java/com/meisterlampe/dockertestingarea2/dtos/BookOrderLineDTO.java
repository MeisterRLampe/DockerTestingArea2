package com.meisterlampe.dockertestingarea2.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class BookOrderLineDTO {


    private int id;
    private Integer idbooks;
    private Timestamp lastModifiedDate;
    private Integer orderQuantity;
    private Timestamp createdDate;
}
