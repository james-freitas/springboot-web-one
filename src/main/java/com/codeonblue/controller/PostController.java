package com.codeonblue.controller;

import com.codeonblue.exception.PostNotFoundException;
import com.codeonblue.model.Post;
import com.codeonblue.service.PostService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping("/list")
    public String listPosts(Model model){
        model.addAttribute("posts", postService.list());
        return "post/list";
    }

    @RequestMapping("/view/{slug}")
    public String view(@PathVariable(value="slug") String slug, Model model){
        model.addAttribute("post", postService.getBySlug(slug));
        return "post/view";
    }

    // Handling Specific Exceptions
    @RequestMapping("/get/{slug}")
    public String getPost(@PathVariable(value = "slug") String slug) throws PostNotFoundException {
        Post post = postService.getBySlug(slug);
        if (post == null) throw new PostNotFoundException("We couldn't find the post with slug: " + slug);
        return "blog/post";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception exception, Model model){
        model.addAttribute("errorMessage", exception.getMessage());
        return "blog/postError";
    }
}
