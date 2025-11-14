package org.java.back_mangashow.repository;

import java.util.List;

import org.java.back_mangashow.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public List<Author> findByFirstNameOrLastNameContaining(String firstName, String lastName);
}
