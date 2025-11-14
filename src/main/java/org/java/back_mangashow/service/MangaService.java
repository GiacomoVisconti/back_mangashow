package org.java.back_mangashow.service;

import java.util.List;
import java.util.Optional;

import org.java.back_mangashow.model.Manga;
import org.java.back_mangashow.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MangaService {
    @Autowired
    private MangaRepository mangaRepository;
    
    public List<Manga> findAll(){
        return mangaRepository.findAll(Sort.by("title"));
    }

    public Optional<Manga> findById(Integer id){
        Optional<Manga> mangaOptional = mangaRepository.findById(id);

        if (mangaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manga non trovato");
        }

        return mangaOptional;
    }

    public List<Manga> findByTitle(String title){
        return mangaRepository.findByTitleContaining(title);
    }

    public Manga create(Manga manga){
        return mangaRepository.save(manga);
    }

    public Manga update(Manga manga){
        return mangaRepository.save(manga);
    }

    public void delete(Integer id){
        mangaRepository.deleteById(id);
    }
}
