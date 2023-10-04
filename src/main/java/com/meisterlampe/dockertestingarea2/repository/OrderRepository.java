package com.meisterlampe.dockertestingarea2.repository;

import com.meisterlampe.dockertestingarea2.entities.Ausleihe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository <Ausleihe,Integer> {

    @Override
    List<Ausleihe> findAllById(Iterable<Integer> integers);

    @Override
    List<Ausleihe> findAll();

    @Override
    Optional<Ausleihe> findById(Integer integer);
}
