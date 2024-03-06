package com.mruruc.repositories;

import com.mruruc.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    // select * from author where first_name = 'john'
    List<Author> findAllByFirstName(String authorName);

    // select * from author where first_name ILIKE 'JOHN'
    List<Author> findAllByFirstNameIgnoreCase(String authorName);

    // select * from author where first_name ILIKE '%Joh%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String authorName);

    // select * from author where first_name ILIKE 'Joh%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String authorName);

    // select * from author where first_name in('Joh','jane','something')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

    @Modifying
    @Transactional
    @Query("update Author a set a.email= :newEmail where a.id= :authorId")
    int updateAuthorEmailById(String newEmail,Long authorId);

}
