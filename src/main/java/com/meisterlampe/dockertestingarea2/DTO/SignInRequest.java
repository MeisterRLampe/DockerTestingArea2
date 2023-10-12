package com.meisterlampe.dockertestingarea2.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SignInRequest {

    private String email;
    private String password;
}
