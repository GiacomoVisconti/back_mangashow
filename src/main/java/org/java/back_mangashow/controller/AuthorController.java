package org.java.back_mangashow.controller;

import org.java.back_mangashow.model.Author;
import org.java.back_mangashow.service.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        
        model.addAttribute("author", authorService.findById(id).get());
        
        return "authors/show";
    }

    @GetMapping("/searchbyname")
    public String search(@RequestParam(name ="name") String name, Model model) {

        model.addAttribute("authors", authorService.findAuthorsByName(name));
        return "authors/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("edit", false);
                
        return "authors/create-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("author") Author formAuthor, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            return "authors/create-edit";
        }
        
        authorService.create(formAuthor);
        return "redirect:/authors/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        model.addAttribute("author", authorService.findById(id).get());
        model.addAttribute("edit", true);
        return "authors/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String postMethodName(@Valid @ModelAttribute("author") Author formAuthor, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            return "authors/create-edit";
        }
        authorService.update(formAuthor);
        return "redirect:/authors/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        authorService.delete(id);
        
        return "redirect:/authors/";
    }
    
    
    
    
    
    

    
    
}
