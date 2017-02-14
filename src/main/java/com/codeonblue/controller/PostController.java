package com.codeonblue.controller;

import com.codeonblue.exception.PostNotFoundException;
import com.codeonblue.model.Author;
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

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

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

    @RequestMapping("/byAuthor/{first}")
    public String byAuthor(@PathVariable(value = "first") String first, Model model ){
        model.addAttribute("posts", postService.byAuthor(first));
        return "post/list";
    }

    @RequestMapping("/byKeyword/{keyword}")
    public String byKeyword( @PathVariable(value = "keyword") String keyword, Model model){
        model.addAttribute("posts", postService.byKeyword(keyword));
        return "post/list";
    }

    /* JSON */
    /*@RequestMapping("/byKeyword/{keyword}")
    public List<Post> byKeyword( @PathVariable(value = "keyword") String keyword){
        return postService.byKeyword(keyword);
    }*/

    @RequestMapping("/byKeywordIgnoreCase/{keyword}")
    public String byKeywordIgnoreCase(@PathVariable (value = "keyword") String keyword, Model model){
        model.addAttribute("posts", postService.byKeywordIgnoreCase(keyword));
        return "post/list";
    }

    /*
    // JSON
    @RequestMapping("/active")
    public List<Post> active(){
        return postService.findActive();
    }
    */


    @RequestMapping("/active")
    public String active(Model model){
        model.addAttribute("posts", postService.findActive());
        return "post/list";
    }

    @RequestMapping("/inactive")
    public String inactive(Model model){
        model.addAttribute("posts", postService.findInactive());
        return "post/list";
    }

    /* JSON */
    /*@RequestMapping("/slug/{slug}")
    public Post findPostBySlug(@PathVariable(value = "slug") String slug) {
        return postService.findBySlug(slug);
    }*/

    @RequestMapping("/slug/{slug}")
    public String findPostBySlug(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("posts", postService.findBySlug(slug));
        return "post/list";
    }

}
