package com.microservice.post.service;

import com.microservice.post.entity.Post;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PostService {
   @Autowired
    private PostRepository pr;

    public Post createPost(Post post) {
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post saved = pr.save(post);
        return saved;
    }

    public Post findPostById(String postId) {
        Post post = pr.findById(postId).get();
        return post;
    }
}
