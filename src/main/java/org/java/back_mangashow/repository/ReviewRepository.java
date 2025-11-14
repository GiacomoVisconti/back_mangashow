package org.java.back_mangashow.repository;

import org.java.back_mangashow.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
}
