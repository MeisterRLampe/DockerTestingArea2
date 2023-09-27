package com.meisterlampe.dockertestingarea2.services;


import com.meisterlampe.dockertestingarea2.entites.CustomerEntity;

import java.util.Optional;

public interface CustomerService {


    Iterable<CustomerEntity> getAllCustomers();

    Optional<CustomerEntity> updateCustomerById(int idcustomer, CustomerEntity customer);
}
