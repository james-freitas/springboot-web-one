package com.codeonblue.service;

import com.codeonblue.model.Post;

import java.util.Collection;

public interface PostService {

    Collection<Post> findAll();

    Post findOne(Long id);

    Post create(Post post);

    Post update(Post post);

    void delete(Long id);
}
