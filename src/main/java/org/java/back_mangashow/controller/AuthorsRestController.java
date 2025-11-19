package org.java.back_mangashow.controller;

import java.util.List;

import org.java.back_mangashow.model.Author;
import org.java.back_mangashow.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin
@RequestMapping("/api/authors")
public class AuthorsRestController {
    
    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public List<Author> index() {
        return authorService.findAll();
    }
    
}
