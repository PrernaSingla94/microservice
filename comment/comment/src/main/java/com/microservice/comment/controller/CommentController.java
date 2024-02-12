package com.microservice.comment.controller;

import com.microservice.comment.entity.Comment;
import com.microservice.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
@Autowired
    private CommentService cs;
//http://localhost:8082/api/comments
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        Comment comment1=cs.createComment(comment);
        return new ResponseEntity<>(comment1, HttpStatus.CREATED);

    }
}
