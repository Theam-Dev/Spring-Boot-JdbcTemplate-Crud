package com.example.crud.controller;

import com.example.crud.models.Post;
import com.example.crud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String Index(Model model) {
        List<Post> post = postService.findAll();
        model.addAttribute("post",post);
        return "post/index";
    }
    @GetMapping("/create")
    public String Create(Model model) {
        Post post = new Post();
        model.addAttribute("post",post);
        return "post/create";
    }
    @GetMapping("/edit/{id}")
    public String Edit(@PathVariable Integer id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post/edit";
    }
    @PostMapping("/save")
    public String Save(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute("post") Post post) {
        postService.update(post);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable (value = "id") Integer id) {
        try {
            postService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
