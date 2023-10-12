package com.meisterlampe.dockertestingarea2.services;


import com.meisterlampe.dockertestingarea2.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {

    UserDetailsService userDetailsService();


    Iterable<User> getAllCustomers();

    Optional<User> updateCustomerById(int iduser, User user);
}
