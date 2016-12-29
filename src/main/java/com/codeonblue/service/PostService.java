package com.codeonblue.service;

import com.codeonblue.model.Post;

import java.util.Collection;
import java.util.List;

public interface PostService {

    Post getLatestPost();

    List<Post> list();

    Post getBySlug(String slug);
}
