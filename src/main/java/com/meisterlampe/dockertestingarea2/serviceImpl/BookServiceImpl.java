package com.meisterlampe.dockertestingarea2.serviceImpl;
import com.meisterlampe.dockertestingarea2.DTO.BookDTO;
import com.meisterlampe.dockertestingarea2.entities.Books;
import com.meisterlampe.dockertestingarea2.repository.BookRepository;
import com.meisterlampe.dockertestingarea2.repository.CategoryRepository;
import com.meisterlampe.dockertestingarea2.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookRepository bookRepository;
    @Resource
    CategoryRepository categoryRepository;

    List<Books> bookList;

    public BookServiceImpl(BookRepository bookRepository, List<Books> bookList,  CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookList = bookList;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public Iterable<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Books> getBooksById(int idbooks) {
        Optional<Books> optionalBook = bookRepository.findByIdbooks(idbooks);

        return optionalBook.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Override
    public Optional<Books> updateBookById(int idbooks, Books bookUpdates) {

        Optional<Books> optionalBook = bookRepository.findById(idbooks);

        if (optionalBook.isPresent()) {
            Books existingBook = optionalBook.get();


            if (bookUpdates.getBooktitle() != null) {
                existingBook.setBooktitle(bookUpdates.getBooktitle());
            }

            if (bookUpdates.getPages() != null) {
                existingBook.setPages(bookUpdates.getPages());
            }

            if (bookUpdates.getPrice() != null) {
                existingBook.setPrice(bookUpdates.getPrice());
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




