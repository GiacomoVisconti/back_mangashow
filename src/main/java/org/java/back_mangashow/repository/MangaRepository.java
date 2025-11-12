package org.java.back_mangashow.repository;

import org.java.back_mangashow.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository  extends JpaRepository<Manga,Integer>{
    
}
