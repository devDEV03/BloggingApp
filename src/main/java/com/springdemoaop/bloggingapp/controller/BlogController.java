package com.springdemoaop.bloggingapp.controller;


import com.springdemoaop.bloggingapp.entity.Comments;
import com.springdemoaop.bloggingapp.entity.Posts;
import com.springdemoaop.bloggingapp.entity.Users;
import com.springdemoaop.bloggingapp.service.BloggingService;
import com.springdemoaop.bloggingapp.service.BloggingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BloggingService bloggingService;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello to My Blogging Application";
    }

    @PostMapping("/users")
    public ResponseEntity<Users> saveUser(@RequestBody Users users){
        return new ResponseEntity<>(bloggingService.saveUsers(users), HttpStatus.CREATED);
    }

    @PostMapping("/posts")
    public ResponseEntity<Posts> savePosts(@RequestBody Posts posts){
        return new ResponseEntity<>(bloggingService.savePosts(posts), HttpStatus.CREATED);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comments> saveComments(@RequestBody Comments comments){
        return new ResponseEntity<>(bloggingService.saveComments(comments), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(bloggingService.getUserById(userId));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long postId){
        return ResponseEntity.ok(bloggingService.getPostById(postId));
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comments> getCommentById(@PathVariable Long commentId){
        return ResponseEntity.ok(bloggingService.getCommentById(commentId));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers(){
        return ResponseEntity.ok(bloggingService.getAllUsers());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Posts>> getPosts(){
        return ResponseEntity.ok(bloggingService.getAllPosts());
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comments>> getComments(){
        return ResponseEntity.ok(bloggingService.getAllComments());
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long userId){
        bloggingService.deleteUser(userId);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long commentId){
        bloggingService.deleteComment(commentId);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long postId){
        bloggingService.deletePost(postId);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> setUser(@PathVariable Long userId, @RequestBody Users users){
        return ResponseEntity.ok(bloggingService.setUser(userId,users));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Posts> setPosts(@PathVariable Long postId, @RequestBody Posts posts){
        return ResponseEntity.ok(bloggingService.setPosts(postId,posts));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comments> setComments(@PathVariable Long commentId, @RequestBody Comments comments){
        return ResponseEntity.ok(bloggingService.setComments(commentId,comments));
    }

}
