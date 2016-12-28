package com.codeonblue.controller;

import com.codeonblue.exception.PostNotFoundException;
import com.codeonblue.model.Post;
import com.codeonblue.service.PostService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("post", postService.getLatestPost());
        return "blog/index";
    }

    // Handling Specific Exceptions
    @RequestMapping("/get/{slug}")
    public String getPost(@PathVariable(value = "slug") String slug) throws PostNotFoundException {
        Post post = postService.findOne(slug);
        if (post == null) throw new PostNotFoundException("We couldn't find the post with slug: " + slug);
        return "blog/post";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception exception, Model model){
        model.addAttribute("errorMessage", exception.getMessage());
        return "blog/postError";
    }
}
