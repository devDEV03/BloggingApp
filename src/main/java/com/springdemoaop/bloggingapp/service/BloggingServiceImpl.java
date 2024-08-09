package com.springdemoaop.bloggingapp.service;

import com.springdemoaop.bloggingapp.entity.Comments;
import com.springdemoaop.bloggingapp.entity.Posts;
import com.springdemoaop.bloggingapp.entity.Users;
import com.springdemoaop.bloggingapp.repository.commentRepository;
import com.springdemoaop.bloggingapp.repository.postRepository;
import com.springdemoaop.bloggingapp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BloggingServiceImpl implements BloggingService{

    @Autowired
    private userRepository userRepo;

    @Autowired
    private postRepository postRepo;

    @Autowired
    private commentRepository commentRepo;

    @Override
    public Users saveUsers(Users users) {
        return userRepo.save(users);
    }

    @Override
    public Posts savePosts(Posts posts) {
        return postRepo.save(posts);
    }

    @Override
    public Comments saveComments(Comments comments) {
        return commentRepo.save(comments);
    }

    @Override
    public Users getUserById(Long userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Account does not exist"));
    }

    @Override
    public Posts getPostById(Long postId) {
        return postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Account does not exist"));
    }

    @Override
    public Comments getCommentById(Long commentId) {
        return commentRepo.findById(commentId).orElseThrow(() -> new RuntimeException("Account does not exist"));
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Posts> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public List<Comments> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public void deleteUser(Long userId) {

        Users user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Account does not exist"));
        userRepo.delete(user);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comments comments = commentRepo.findById(commentId).orElseThrow(() -> new RuntimeException(""));
        commentRepo.delete(comments);
    }

    @Override
    public void deletePost(Long postId) {
        Posts posts = postRepo.findById(postId).orElseThrow(() -> new RuntimeException(""));
        postRepo.delete(posts);
    }


}
