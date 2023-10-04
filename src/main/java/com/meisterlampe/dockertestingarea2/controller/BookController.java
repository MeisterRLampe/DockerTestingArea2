package com.meisterlampe.dockertestingarea2.controller;
import com.meisterlampe.dockertestingarea2.entites.Books;
import com.meisterlampe.dockertestingarea2.repository.BookRepository;
import com.meisterlampe.dockertestingarea2.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
    @Resource
    private final BookService bookService;
    @Resource
    private final BookRepository bookRepository;

    @RequestMapping(value = "/delete/{idbooks}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }


    public BookController(BookService bookService,
                          BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    //All Books

    @GetMapping("/allbooks")
    public Iterable<Books> getAllBooks() {

        return bookService.getAllBooks();
    }


    //Create a Book
    @RequestMapping(value="/book/create", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody Books book){

        bookRepository.save(book);
    }

    //Book  by ID

    @RequestMapping(value = "book/{idbooks}", method = RequestMethod.GET)
    public Object booksTitleById(@PathVariable int idbooks) {

        Optional<Books> bookDTO = bookRepository.findById(idbooks);


        return bookDTO;
    }

    // Update

    @PutMapping("/book/update/{idbooks}")
    public Optional<Books> updateBookAttributeById(@PathVariable("idbooks") int idbooks, @RequestBody Books bookUpdates) {

        Optional<Books> updatedBook = bookService.updateBookById(idbooks,bookUpdates);

        if(updatedBook.isPresent()){
            return Optional.of(updatedBook.get());
        }
        else{
                return Optional.empty();
        }
    }

    //Delete by ID

    @RequestMapping(value="/book/delete/{idbooks}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBookById (@PathVariable int idbooks){
        try {
            bookRepository.deleteById(idbooks);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }}





}



