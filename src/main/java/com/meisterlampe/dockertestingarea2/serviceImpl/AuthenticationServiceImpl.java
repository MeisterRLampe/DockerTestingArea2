package com.meisterlampe.dockertestingarea2.serviceImpl;

import com.meisterlampe.dockertestingarea2.DTO.JwtAuthenticationResponse;
import com.meisterlampe.dockertestingarea2.DTO.RefreshTokenRequest;
import com.meisterlampe.dockertestingarea2.DTO.SignInRequest;
import com.meisterlampe.dockertestingarea2.DTO.SignUpRequest;
import com.meisterlampe.dockertestingarea2.entities.Role;
import com.meisterlampe.dockertestingarea2.entities.User;
import com.meisterlampe.dockertestingarea2.repository.UserRepository;
import com.meisterlampe.dockertestingarea2.services.AuthenticationService;
import com.meisterlampe.dockertestingarea2.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signup(SignUpRequest signUpRequest){

        User user = new User();

        user.setUsername(signUpRequest.getLoginId());
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest){

        if (signInRequest.getLoginId() != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getLoginId(),
                    signInRequest.getPassword()));

            var user = userRepository.findByUsername(signInRequest.getLoginId()).orElseThrow(() -> new IllegalArgumentException("Invalid user or password!"));
            var jwt = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshToken);
            return jwtAuthenticationResponse;


        } else if (signInRequest.getEmail() != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

            var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid user or password!"));
            var jwt = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshToken);
            return jwtAuthenticationResponse;
        }

        return null;

    }
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByUsername(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
            var jwt = jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

}
