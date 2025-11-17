package org.java.back_mangashow.controller;

import java.util.List;

import org.java.back_mangashow.model.Manga;
import org.java.back_mangashow.model.Review;
import org.java.back_mangashow.service.ReviewService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/api/reviews")
public class ReviewRestController {
    
    @Autowired ReviewService reviewService;

    @GetMapping("/")
    public List<Review> index() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> show(@PathVariable Integer id) {

        if (reviewService.findById(id).isEmpty()) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviewService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Review> store(@RequestBody Review review) {
        
        return new ResponseEntity<Review>(reviewService.create(review), HttpStatus.OK);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable Integer id, @RequestBody Review review) {
        
        if (reviewService.findById(id).isEmpty()) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Review>(reviewService.update(review), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Review> delete(@PathVariable Integer id){
        if (reviewService.findById(id).isEmpty()) {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }

        reviewService.delete(id);
        return new ResponseEntity<Review>(HttpStatus.OK);
    }


    
}
