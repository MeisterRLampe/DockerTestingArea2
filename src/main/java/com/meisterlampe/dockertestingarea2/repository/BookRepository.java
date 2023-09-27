package com.meisterlampe.dockertestingarea2.repository;
import com.meisterlampe.dockertestingarea2.entites.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {


    Optional<BookEntity> findByIdbooks(int idbook);

    @Transactional
    @Modifying
    @Query("update BookEntity b set b.bookTitle = ?1 where b.idbooks = ?2")
    int updateTitleByIdbooks(@NonNull String title, int idbooks);



}
