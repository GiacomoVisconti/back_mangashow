package org.java.back_mangashow.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The title field must be popolized")
    private String title;

    @NotNull
    private Integer year_of_publication;

    @NotNull
    private Boolean isConcluded;

    @Lob
    private String synopsis;

    @Lob
    private String image_url;

    //!RELAZIONE CON IN GENERI
    @ManyToMany
    @JoinTable(
        name = "genre_manga",
        joinColumns = @JoinColumn(name = "manga_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    //!RELAZIONE CON GLI AUTORI
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Boolean getIsConcluded() {
        return isConcluded;
    }

    public void setIsConcluded(Boolean isConcluded) {
        this.isConcluded = isConcluded;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(Integer year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

}
