package org.java.back_mangashow.service;

import java.util.List;
import java.util.Optional;

import org.java.back_mangashow.model.Review;
import org.java.back_mangashow.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Integer id){
        return reviewRepository.findById(id);
    }

    public Review create(Review review){
        return reviewRepository.save(review);
    }

    public Review update(Review review){
        return reviewRepository.save(review);
    }

    public void delete(Integer id){
        reviewRepository.deleteById(id);
    }


}
