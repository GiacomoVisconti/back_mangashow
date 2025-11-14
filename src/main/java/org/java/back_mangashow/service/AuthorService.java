package org.java.back_mangashow.service;

import java.util.List;
import java.util.Optional;

import org.java.back_mangashow.model.Author;
import org.java.back_mangashow.model.Manga;
import org.java.back_mangashow.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Integer id){

        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
            
        }

        return authorOptional;
    }

    public List<Author> findAuthorsByName(String query){
        return authorRepository.findByFirstNameOrLastNameContaining(query, query);
    }

    public Author create(Author author){
    
        return authorRepository.save(author);
    }

    public Author update(Author author){
    
        return authorRepository.save(author);
    }

    public void delete(Integer id){
        authorRepository.deleteById(id);
    }

}
