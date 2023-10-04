package com.meisterlampe.dockertestingarea2.repository;
import com.meisterlampe.dockertestingarea2.entites.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Books, Integer> {


    Optional<Books> findByIdbooks(int idbook);

    @Transactional
    @Modifying
    @Query("update Books b set b.booktitle = ?1 where b.idbooks = ?2")
    int updateTitleByIdbooks(@NonNull String title, int idbooks);



}
