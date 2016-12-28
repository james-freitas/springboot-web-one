package com.codeonblue.repository;

import com.codeonblue.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{
    Post findFirstByOrderByPostedOnDesc();
    Post findBySlug(String slug);
}


