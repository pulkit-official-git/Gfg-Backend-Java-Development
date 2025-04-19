package com.example.demo_gfg_JPA.repositories;

import com.example.demo_gfg_JPA.models.Book;
import com.example.demo_gfg_JPA.models.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query(value="select * from my_book where genr= :genre",nativeQuery = true)
//    List<Book> getBookByGenreNative(Genre genre);
//
//    @Query("select b from Book b where b.genre= ?1")
//    List<Book> getBookByGenreJPQL(Genre genre);

    @Query(value="select * from my_book b where b.genre = ?1",nativeQuery = true)
    List<Book> getByGenreNative(Genre genre);

    List<Book> findByGenre(Genre genre);

    List<Book> findBooksByGenreOrAuthorEmail(Genre genre, String email);

    @Transactional
    @Modifying
    @Query("update Book b set b.genre= ?1 where b.id = ?2")
    void updateGenreById(Genre genre, Long id);
}

