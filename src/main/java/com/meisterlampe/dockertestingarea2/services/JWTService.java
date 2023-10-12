package com.meisterlampe.dockertestingarea2.services;

import com.meisterlampe.dockertestingarea2.DTO.JwtAuthenticationResponse;
import com.meisterlampe.dockertestingarea2.DTO.SignInRequest;
import com.meisterlampe.dockertestingarea2.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {

    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token,UserDetails userDetails);

    String generateRefreshToken(Map<String,Object> extraClaims , UserDetails userDetails);

}
