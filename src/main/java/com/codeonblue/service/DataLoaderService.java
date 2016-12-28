package com.codeonblue.service;

import com.codeonblue.model.Author;
import com.codeonblue.model.Post;
import com.codeonblue.repository.AuthorRepository;
import com.codeonblue.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
public class DataLoaderService {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public DataLoaderService(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    private void loadData() {
        Author jd = new Author("James", "Freitas");
        jd.setEmail("jamesfrj@yahoo.com.br");
        authorRepository.save(jd);

        Post firstPost = new Post("Spring Data Rocks!");
        firstPost.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation" +
                " ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non" +
                " proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        firstPost.setPostedOn(LocalDateTime.now());
        firstPost.setSlug("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation" +
                " ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non" +
                " proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        firstPost.setTeaser("Teaser from post one");
        firstPost.setAuthor(jd);
        postRepository.save(firstPost);
    }
}
