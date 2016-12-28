package com.codeonblue.service;

import com.codeonblue.model.Post;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PostServiceBean implements PostService{

    private static Long nextId;
    private static Map<Long, Post> postMap;

    private static Post save(Post post) {
        if (postMap == null) {
            postMap = new HashMap<Long, Post>();
            nextId = new Long(1);
        }
        // If Update...
        if (post.getId() != null) {
            Post oldPost = postMap.get(post.getId());
            if (oldPost == null) {
                return null;
            }
            postMap.remove(post.getId());
            postMap.put(post.getId(), post);
            return post;
        }
        // If Create...
        post.setId(nextId);
        nextId += 1;
        postMap.put(post.getId(), post);
        return post;
    }

    private static boolean remove(Long id) {
        Post deletedPost = postMap.remove(id);
        if (deletedPost == null) {
            return false;
        }
        return true;
    }

    static {
        Post g1 = new Post("Hello World!");
        save(g1);

        Post g2 = new Post("Hola Mundo!");
        save(g2);
    }

    @Override
    public Collection<Post> findAll() {

        Collection<Post> posts = postMap.values();

        return posts;
    }

    @Override
    public Post findOne(Long id) {

        Post post = postMap.get(id);

        return post;
    }

    @Override
    public Post create(Post post) {

        Post savedPost = save(post);

        return savedPost;
    }

    @Override
    public Post update(Post post) {

        Post updatedPost = save(post);

        return updatedPost;
    }

    @Override
    public void delete(Long id) {

        remove(id);

    }

}
