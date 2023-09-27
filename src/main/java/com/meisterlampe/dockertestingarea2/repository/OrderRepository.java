package com.meisterlampe.dockertestingarea2.repository;

import com.meisterlampe.dockertestingarea2.entites.BookOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository <BookOrderEntity,Integer> {

    @Override
    List<BookOrderEntity> findAllById(Iterable<Integer> integers);

    @Override
    List<BookOrderEntity> findAll();

    @Override
    Optional<BookOrderEntity> findById(Integer integer);
}
