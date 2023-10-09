package com.meisterlampe.dockertestingarea2.DTO;

import lombok.Data;

@Data
public class BookDTO {

    private String booktitle;
    private String price;
    private String pages;
    private String bookentry;
    private int idcategory;
    private String releaseDate;
    private int stock;
}
