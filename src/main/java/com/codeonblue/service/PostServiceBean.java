package com.codeonblue.service;

import com.codeonblue.model.Post;
import com.codeonblue.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PostServiceBean implements PostService{

    private final PostRepository postRepository;

    @Autowired
    public PostServiceBean(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getLatestPost() {
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    @Override
    public Post findOne(String slug) {
        return postRepository.findBySlug(slug);
    }

}
