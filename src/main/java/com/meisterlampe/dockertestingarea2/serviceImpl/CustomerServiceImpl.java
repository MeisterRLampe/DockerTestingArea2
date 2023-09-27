package com.meisterlampe.dockertestingarea2.serviceImpl;

import com.meisterlampe.dockertestingarea2.entites.CustomerEntity;
import com.meisterlampe.dockertestingarea2.repository.CustomerRepository;
import com.meisterlampe.dockertestingarea2.services.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerRepository customerRepository;

    List<CustomerEntity> customerList;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Iterable<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<CustomerEntity> updateCustomerById(int idcustomer, CustomerEntity customer) {

        Optional<CustomerEntity> optionalCustomerDTO = customerRepository.findById(idcustomer);

        if (optionalCustomerDTO.isPresent()) {
            CustomerEntity existingCustomer = optionalCustomerDTO.get();

            if (customer.getName() != null) {
                existingCustomer.setName(customer.getName());
            }

            if (customer.getAddress() != null) {
                existingCustomer.setAddress(customer.getAddress());
            }

            customerRepository.save(existingCustomer);

            return Optional.of(existingCustomer);

        }
        else{
            return Optional.empty();

        }
    }
}
