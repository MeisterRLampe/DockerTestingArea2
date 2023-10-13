package com.meisterlampe.dockertestingarea2.DTO;

import lombok.Data;

@Data
public class SignUpRequest {


    private String loginId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
