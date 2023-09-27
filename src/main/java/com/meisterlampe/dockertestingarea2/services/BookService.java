package com.meisterlampe.dockertestingarea2.services;

import com.meisterlampe.dockertestingarea2.dtos.BookDTO;
import com.meisterlampe.dockertestingarea2.entites.BookEntity;

import java.util.List;
import java.util.Optional;


public interface BookService {

    Iterable<BookEntity> getAllBooks();

    List<BookEntity> getBooksById(int idbooks);

    Optional<BookEntity> updateBookById(int idbooks, BookEntity book);

    void createBook(BookDTO bookDTO);
}
