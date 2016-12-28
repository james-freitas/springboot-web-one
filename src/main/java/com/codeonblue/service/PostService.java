package com.codeonblue.service;

import com.codeonblue.model.Post;

import java.util.Collection;

public interface PostService {

    Post getLatestPost();

    Post findOne(String slug);
}
