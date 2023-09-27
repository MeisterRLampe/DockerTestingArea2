package com.meisterlampe.dockertestingarea2.repository;

import com.meisterlampe.dockertestingarea2.entites.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

    @Override
    List<CustomerEntity> findAllById(Iterable<Integer> integers);

    @Override
    List<CustomerEntity> findAll();

    @Override
    Optional<CustomerEntity> findById(Integer integer);

    @Transactional
    @Modifying
    @Query("update CustomerEntity c set c.name = ?1, c.address = ?2 where c.idcustomer = ?3")
    int UpdateCustomerById(String name, String address, @NonNull int idcustomer);


}
