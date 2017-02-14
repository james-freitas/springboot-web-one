package com.codeonblue.service;

import com.codeonblue.model.Author;
import com.codeonblue.model.Post;
import com.codeonblue.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceBean implements PostService{

    private final PostRepository postRepository;

    @Autowired
    public PostServiceBean(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post getLatestPost(){
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<Post> list() {
        return postRepository.findAllByOrderByPostedOnDesc();
    }

    public Post getBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

    @Override
    public List<Post> byAuthor(String first) {
        return postRepository.findAllByAuthorFirstNameIgnoreCase(first);
    }

    @Override
    public List<Post> byKeyword(String keyword) {
        return postRepository.findAllByKeywords(keyword);
    }

    @Override
    public List<Post> byKeywordIgnoreCase(String keyword) {
        return postRepository.findAllByKeywordsLikeIgnoreCase('%' + keyword + '%');
    }

    @Override
    public List<Post> findActive() {
        return postRepository.findAllByActiveTrue();
    }

    @Override
    public List<Post> findInactive() {
        return postRepository.findAllByActiveFalse();
    }

    @Override
    public Post findBySlug(String slug) {
        return postRepository.findPostBySlug(slug);
    }


}
