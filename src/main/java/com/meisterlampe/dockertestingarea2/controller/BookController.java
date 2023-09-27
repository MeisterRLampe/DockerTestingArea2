package com.meisterlampe.dockertestingarea2.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meisterlampe.dockertestingarea2.entites.BookEntity;
import com.meisterlampe.dockertestingarea2.dtos.BookDTO;
import com.meisterlampe.dockertestingarea2.repository.BookRepository;
import com.meisterlampe.dockertestingarea2.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController()
@RequestMapping("/api")

public class BookController {
    @Resource
    private final BookService bookService;
    private final BookRepository bookRepository;

    ObjectMapper objectMapper = new ObjectMapper();



    public BookController(BookService bookService,
                          BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    //All Books

    @GetMapping("/allbooks")
    public Iterable<BookEntity> getAllBooks() {

        return bookService.getAllBooks();
    }


    //Create a Book
    @RequestMapping(value="/book/create", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookEntity book){

        bookRepository.save(book);
    }

    //Book  by ID

    @RequestMapping(value = "book/{idbooks}", method = RequestMethod.GET)
    public Object booksTitleById(@PathVariable int idbooks) {

        Optional<BookEntity> bookDTO = bookRepository.findById(idbooks);


        return bookDTO;
    }

    // Update

    @PutMapping("/book/update/{idbooks}")
    public Optional<BookEntity> updateBookAttributeById(@PathVariable("idbooks") int idbooks, @RequestBody BookEntity bookUpdates) {

        Optional<BookEntity> updatedBook = bookService.updateBookById(idbooks,bookUpdates);

        if(updatedBook.isPresent()){
            return Optional.of(updatedBook.get());
        }
        else{
                return Optional.empty();
        }
    }

    //Delete by ID

    @RequestMapping(value="/book/delete/{idbooks}", method = RequestMethod.DELETE)
    public void deleteBookById (@PathVariable int idbooks){

        bookRepository.deleteById(idbooks);
    }





}



