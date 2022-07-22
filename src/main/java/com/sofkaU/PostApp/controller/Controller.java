package com.sofkaU.PostApp.controller;

import com.sofkaU.PostApp.entity.Comment;
import com.sofkaU.PostApp.entity.Post;
import com.sofkaU.PostApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controller {

    @Autowired
    private PostService postService;

    @GetMapping(path = "/posts")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @PostMapping(path = "/post")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PostMapping(path = "/comment")
    public Post createComment(@RequestBody Comment comment){
        return postService.createComment(comment);
    }

    @DeleteMapping(path = "/post/{id}")
    public void deletePost(@PathVariable(value="id") Long id){
        postService.deletePost(id);
    }

    @DeleteMapping(path = "/comment/{id}")
    public void deleteComment(@PathVariable(value="id") Long id){
        postService.deleteComment(id);
    }

}
