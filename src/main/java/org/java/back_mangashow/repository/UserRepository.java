package org.java.back_mangashow.repository;

import org.java.back_mangashow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
