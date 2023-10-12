package com.meisterlampe.dockertestingarea2.repository;

import com.meisterlampe.dockertestingarea2.entities.Role;
import com.meisterlampe.dockertestingarea2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByRole(Role role);

    Optional<User> findByEmail(String email);

    @Override
    List<User> findAllById(Iterable<Integer> integers);

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Integer integer);

    boolean existsByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Transactional
    @Modifying
    @Query("""
            update User u set u.iduser = ?1
            where u.username = ?2 and u.firstname = ?3 and u.lastname = ?4 and u.address = ?5 and u.zipcode = ?6 and u.email = ?7 and u.country = ?8 and u.dob = ?9 and u.createdAt = ?10 and u.password = ?11""")
    int UpdateCustomerById(int iduser, String username, String firstname, String lastname, String address, String zipcode, String email, String country, Date dob, Timestamp createdAt, String password);



}
