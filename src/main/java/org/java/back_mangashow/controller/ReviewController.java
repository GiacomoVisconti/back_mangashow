package org.java.back_mangashow.controller;

import java.util.stream.Gatherer.Integrator;

import org.java.back_mangashow.model.Review;
import org.java.back_mangashow.service.MangaService;
import org.java.back_mangashow.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MangaService mangaService;
    
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("reviews", reviewService.findAll());
        return "reviews/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("review", new Review());
        model.addAttribute("mangas", mangaService.findAll());
        model.addAttribute("edit", false);
        return "reviews/create-edit";
    }
    
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("review") Review formReview, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
        model.addAttribute("mangas", mangaService.findAll());
            return "review/create-edit";
        }
        
        reviewService.create(formReview);
        return "redirect:/reviews/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        
        model.addAttribute("review", reviewService.findById(id).get());
        model.addAttribute("mangas", mangaService.findAll());
        model.addAttribute("edit", true);        
        return "reviews/create-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("review") Review formReview, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        model.addAttribute("mangas", mangaService.findAll());
        
            return "reviews/create-edit";
        }
        
        reviewService.create(formReview);
        return "redirect:/reviews/";
    }
    
    @PostMapping("/delete/{id}")
    public String postMethodName(@PathVariable Integer id) {
        
        reviewService.delete(id);
        
        return "redirect:/reviews/";
    }
    
    
    
    
}
