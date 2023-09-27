package com.meisterlampe.dockertestingarea2.controller;
import com.meisterlampe.dockertestingarea2.entites.CustomerEntity;
import com.meisterlampe.dockertestingarea2.repository.CustomerRepository;
import com.meisterlampe.dockertestingarea2.services.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Resource
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    public CustomerController(CustomerRepository customerRepository, CustomerService customerService
    ) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;

    }

    //Create a Customer
    @RequestMapping(value = "/customer/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody CustomerEntity customerEntity) {

        customerRepository.save(customerEntity);
    }


    //Read User by ID

    @GetMapping("/customer/{idcustomer}")
    public Object getCustomerById(@PathVariable int idcustomer) {

        Optional<CustomerEntity> customerDTO = customerRepository.findById(idcustomer);

        return customerDTO;
    }


    //Read all Customers
    @GetMapping("/allcustomer")
    public Iterable<CustomerEntity> getAllCustomer() {

        return customerService.getAllCustomers();
    }


    //Update User by ID
    @PutMapping(value = "/customer/update/{idcustomer}")
    public Optional<CustomerEntity> updateCustomerByID(@PathVariable int idcustomer, @RequestBody CustomerEntity customerUpdates) {

        Optional<CustomerEntity> updatedCustomer = customerService.updateCustomerById(idcustomer, customerUpdates);

        if(updatedCustomer.isPresent()){
            return Optional.of(updatedCustomer.get());
        }
        else{
            return Optional.empty();
        }

    }

    //Delete User by ID
    @RequestMapping(value = "/customer/delete/{idcustomer}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable int idcustomer){
        customerRepository.deleteById(idcustomer);
    }



}
