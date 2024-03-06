package com.mruruc.services;

import com.mruruc.models.Author;
import com.mruruc.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }

    public void addAuthor(Author author){
        author.setCreatedAt(LocalDateTime.now());
        author.setCreatedBy(author.getFirstName());
        author.setLastModifiedAt(LocalDateTime.now());
        authorRepository.save(author);
    }

    public List<Author> authors(){
        return authorRepository.findAll();
    }
}
