package com.meisterlampe.dockertestingarea2.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BookOrderDTO {

    private int idorder;
    private Integer idcustomer;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
    private Long orderVersion;

}
