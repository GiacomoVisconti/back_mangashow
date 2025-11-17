package org.java.back_mangashow.controller;

import java.util.List;

import org.java.back_mangashow.model.Manga;
import org.java.back_mangashow.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@CrossOrigin
@RequestMapping("/api/mangas")
public class MangaRestController {
    
    @Autowired MangaService mangaService;

    @GetMapping("/")
    public List<Manga> index() {
        return mangaService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Manga> show(@PathVariable Integer id) {

        if (mangaService.findById(id).isEmpty()) {
            return new ResponseEntity<Manga>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mangaService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Manga> store(@RequestBody Manga manga) {
        
        return new ResponseEntity<Manga>(mangaService.create(manga), HttpStatus.OK);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> update(@PathVariable Integer id, @RequestBody Manga manga) {
        
        if (mangaService.findById(id).isEmpty()) {
            return new ResponseEntity<Manga>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Manga>(mangaService.update(manga), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Manga> delete(@PathVariable Integer id){
        if (mangaService.findById(id).isEmpty()) {
            return new ResponseEntity<Manga>(HttpStatus.NOT_FOUND);
        }

        mangaService.delete(id);
        return new ResponseEntity<Manga>(HttpStatus.OK);
    }


}
