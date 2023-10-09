package com.meisterlampe.dockertestingarea2.services;

import com.meisterlampe.dockertestingarea2.DTO.BookDTO;
import com.meisterlampe.dockertestingarea2.entities.Books;

import java.util.List;
import java.util.Optional;


public interface BookService {

    Iterable<Books> getAllBooks();

    List<Books> getBooksById(int idbooks);

    Optional<Books> updateBookById(int idbooks, Books book);


    void createBook(BookDTO bookDTO);
}
