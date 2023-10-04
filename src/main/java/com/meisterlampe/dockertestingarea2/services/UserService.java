package com.meisterlampe.dockertestingarea2.services;


import com.meisterlampe.dockertestingarea2.entities.User;

import java.util.Optional;

public interface UserService {


    Iterable<User> getAllCustomers();

    Optional<User> updateCustomerById(int iduser, User user);
}