package org.java.back_mangashow.controller;

import java.util.List;

import org.java.back_mangashow.model.Genre;
import org.java.back_mangashow.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin
@RequestMapping("/api/genres")
public class GenresRestController {
    
    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/")
    public List<Genre> index() {
        return genreRepository.findAll();
    }
    
}
