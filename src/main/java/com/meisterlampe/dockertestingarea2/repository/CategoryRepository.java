package com.meisterlampe.dockertestingarea2.repository;

import com.meisterlampe.dockertestingarea2.entities.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    void flush();

    @Override
    <S extends Category> S saveAndFlush(S entity);

    @Override
    <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Category> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Category> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    void deleteAllInBatch();

    @Override
    Category getOne(Integer integer);

    @Override
    Category getById(Integer integer);

    @Override
    Category getReferenceById(Integer integer);

    @Override
    <S extends Category> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Category> List<S> findAll(Example<S> example);

    @Override
    <S extends Category> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Category> long count(Example<S> example);

    @Override
    <S extends Category> boolean exists(Example<S> example);

    @Override
    <S extends Category, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Override
    <S extends Category> S save(S entity);

    @Override
    <S extends Category> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Category> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    List<Category> findAll();

    @Override
    List<Category> findAllById(Iterable<Integer> integers);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Category entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Category> entities);

    @Override
    void deleteAll();

    @Override
    List<Category> findAll(Sort sort);

    @Override
    Page<Category> findAll(Pageable pageable);
}


