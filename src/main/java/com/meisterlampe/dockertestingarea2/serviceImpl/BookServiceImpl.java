package com.meisterlampe.dockertestingarea2.serviceImpl;
import com.meisterlampe.dockertestingarea2.dtos.BookDTO;
import com.meisterlampe.dockertestingarea2.entites.BookEntity;
import com.meisterlampe.dockertestingarea2.repository.BookRepository;
import com.meisterlampe.dockertestingarea2.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookRepository bookRepository;

    List<BookEntity> bookList;

    public BookServiceImpl(BookRepository bookRepository, List<BookEntity> bookList) {
        this.bookRepository = bookRepository;
        this.bookList = bookList;

    }

    @Override
    public Iterable<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<BookEntity> getBooksById(int idbooks) {
        Optional<BookEntity> optionalBook = bookRepository.findByIdbooks(idbooks);

        return optionalBook.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Override
    public Optional<BookEntity> updateBookById(int idbooks, BookEntity bookUpdates) {

        Optional<BookEntity> optionalBook = bookRepository.findById(idbooks);

        if (optionalBook.isPresent()) {
            BookEntity existingBook = optionalBook.get();


            if (bookUpdates.getBookTitle() != null) {
                existingBook.setBookTitle(bookUpdates.getBookTitle());
            }

            if (bookUpdates.getPages() != null) {
                existingBook.setPages(bookUpdates.getPages());
            }

            if (bookUpdates.getPrice() != null) {
                existingBook.setPrice(bookUpdates.getPrice());
            }
            if(bookUpdates.getBookVersion()!=null){
                existingBook.setBookVersion(bookUpdates.getBookVersion());
            }
            if(bookUpdates.getReleaseDate()!=null){
                existingBook.setReleaseDate(bookUpdates.getReleaseDate());
            }

            bookRepository.save(existingBook);
            return Optional.of(existingBook);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void createBook(BookDTO bookDTO) {

    }

}




