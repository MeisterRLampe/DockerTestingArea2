package com.meisterlampe.dockertestingarea2.services;

import com.meisterlampe.dockertestingarea2.DTO.JwtAuthenticationResponse;
import com.meisterlampe.dockertestingarea2.DTO.RefreshTokenRequest;
import com.meisterlampe.dockertestingarea2.DTO.SignInRequest;
import com.meisterlampe.dockertestingarea2.DTO.SignUpRequest;
import com.meisterlampe.dockertestingarea2.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
