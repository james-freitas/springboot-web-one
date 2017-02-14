package com.codeonblue.service;

import com.codeonblue.model.Author;
import com.codeonblue.model.Post;


import java.util.Collection;
import java.util.List;

public interface PostService {

    Post getLatestPost();

    List<Post> list();

    Post getBySlug(String slug);

    List<Post> byAuthor(String first);

    List<Post> byKeyword(String keyword);

    List<Post> byKeywordIgnoreCase(String keyword);

    List<Post> findActive();

    List<Post> findInactive();

    Post findBySlug(String slug);
}
