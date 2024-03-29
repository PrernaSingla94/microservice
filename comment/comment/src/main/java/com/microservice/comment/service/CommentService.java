package com.microservice.comment.service;

import com.microservice.comment.config.RestTemplateConfig;
import com.microservice.comment.entity.Comment;
import com.microservice.comment.payload.Post;
import com.microservice.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepository cr;
    @Autowired
    private RestTemplateConfig restTemplate;
    public Comment createComment(Comment comment) {
        Post post = restTemplate.getRestTemplate().getForObject("http://localhost:8081/api/posts/" + comment.getPostId(), Post.class);
    if(post!=null){
        String commentId = UUID.randomUUID().toString();
        comment.setId(commentId);
        Comment saved = cr.save(comment);
        return saved;
    }else{
        return null;
    }
    }
}
