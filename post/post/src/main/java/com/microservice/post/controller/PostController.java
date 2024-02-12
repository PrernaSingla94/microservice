package com.microservice.post.controller;

import com.microservice.post.entity.Post;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService ps;
    //http://localhost:8082/api/posts
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){

        Post newPost= ps.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
    //http://localhost:8082/api/posts/copyanypostid from workbench
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable String postId){

        Post post= ps.findPostById(postId);
        return post;
    }
}
