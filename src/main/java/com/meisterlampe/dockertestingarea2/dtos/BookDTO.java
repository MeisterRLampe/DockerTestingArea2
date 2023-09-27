package com.meisterlampe.dockertestingarea2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private String title;
    private int pages;
    private double price;
    private String version;
    private String release;
    private String bookEntry;
}
