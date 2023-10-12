package com.meisterlampe.dockertestingarea2.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;
}
