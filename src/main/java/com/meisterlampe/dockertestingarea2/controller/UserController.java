package com.meisterlampe.dockertestingarea2.controller;
import com.meisterlampe.dockertestingarea2.entities.User;
import com.meisterlampe.dockertestingarea2.repository.UserRepository;
import com.meisterlampe.dockertestingarea2.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    private final UserRepository userRepository;
    @Resource
    private final UserService userService;


    @GetMapping(value = "/user")
    public ResponseEntity<String> sayHello(){

        return ResponseEntity.ok("Hi User");
    }

    public UserController(UserRepository userRepository, UserService userService
    ) {
        this.userRepository = userRepository;
        this.userService = userService;

    }

    //Create a Customer
    @RequestMapping(value = "/customer/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody User user) {

        userRepository.save(user);
    }


    //Read User by ID

    @GetMapping("/customer/{iduser}")
    public Object getCustomerById(@PathVariable int iduser) {

        return userRepository.findById(iduser);
    }


    //Read all Customers
    @GetMapping("/allcustomer")
    public Iterable<User> getAllCustomer() {

        return userService.getAllCustomers();
    }


    //Update User by ID
    @PutMapping(value = "/customer/update/{idcustomer}")
    public Optional<User> updateCustomerByID(@PathVariable int idcustomer, @RequestBody User customerUpdates) {

        Optional<User> updatedCustomer = userService.updateCustomerById(idcustomer, customerUpdates);

        return updatedCustomer.isPresent() ?  Optional.of(updatedCustomer.get()):  Optional.empty();

    }

    //Delete User by ID
    @RequestMapping(value = "/customer/delete/{iduser}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable int iduser){
        userRepository.deleteById(iduser);
    }



}
