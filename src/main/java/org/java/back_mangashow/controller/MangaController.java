package org.java.back_mangashow.controller;

import java.util.Optional;

import org.java.back_mangashow.model.Manga;
import org.java.back_mangashow.repository.AuthorRepository;
import org.java.back_mangashow.repository.GenreRepository;
import org.java.back_mangashow.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
@RequestMapping("/mangas")
public class MangaController {
    
    @Autowired
    private MangaService mangaService;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public String Index(Model model) {
        
        model.addAttribute("mangas", mangaService.findAll());
        return "mangas/index";
    }
    
    @GetMapping("/searchbytitle")
    public String search(@RequestParam(name ="title") String title, Model model) {

        model.addAttribute("mangas", mangaService.findByTitle(title));

        return "mangas/index";
    }
    

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Manga> mangaAttempt = mangaService.findById(id);

        Manga manga = mangaAttempt.get();
        model.addAttribute("manga", manga);
        return "mangas/show";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("manga", new Manga());
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("edit", false);
        return "mangas/create-edit";
    }
    
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("manga") Manga formManga, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("genres", genreRepository.findAll());
            model.addAttribute("authors", authorRepository.findAll());
            
            return "mangas/create-edit";
        }
        
        mangaService.create(formManga);
        
        return "redirect:/mangas/";
    }
    
    @GetMapping("/edit/{id}")
    public String edti(@PathVariable Integer id, Model model) {
        model.addAttribute("manga", mangaService.findById(id).get());
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("edit", true);

        return "mangas/create-edit";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("manga") Manga formManga, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("genres", genreRepository.findAll());
            model.addAttribute("authors", authorRepository.findAll());
            
            return "mangas/create-edit";
        }
        
        mangaService.update(formManga);
        
        return "redirect:/mangas/";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        mangaService.delete(id);
        
        return "redirect:/mangas/";
    }
    
    
    
}
