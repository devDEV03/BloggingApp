package com.springdemoaop.bloggingapp.service;

import com.springdemoaop.bloggingapp.entity.Comments;
import com.springdemoaop.bloggingapp.entity.Posts;
import com.springdemoaop.bloggingapp.entity.Users;
import com.springdemoaop.bloggingapp.repository.commentRepository;
import com.springdemoaop.bloggingapp.repository.postRepository;
import com.springdemoaop.bloggingapp.repository.userRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


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

    @Override
    public Users setUser(Long userId, Users users) {
        Users user1 = userRepo.findById(userId).orElseThrow(() -> new RuntimeException(""));

        if(Objects.nonNull(users.getUsername()) && !"".equalsIgnoreCase(users.getUsername())){
            user1.setUsername(users.getUsername());
        }

        if(Objects.nonNull(users.getPassword()) && !"".equalsIgnoreCase(users.getPassword())){
            user1.setPassword(users.getPassword());
        }

        if(Objects.nonNull(users.getEmail()) && !"".equalsIgnoreCase(users.getEmail())){
            user1.setEmail(users.getEmail());
        }
        return users;
    }

    @Override
    public Posts setPosts(Long postId, Posts posts) {
        Posts postDep = postRepo.findById(postId).orElseThrow(() -> new RuntimeException(""));

        if (Objects.nonNull(posts.getTitle()) && !"".equalsIgnoreCase(posts.getTitle())){
            postDep.setTitle(posts.getTitle());
        }
        if (Objects.nonNull(posts.getContent()) && !"".equalsIgnoreCase(posts.getContent())){
            postDep.setContent(posts.getContent());
        }
        if (Objects.nonNull(posts.getUsers())){
            postDep.setUsers(posts.getUsers());
        }
        if (Objects.nonNull(posts.getCreatedAt())){
            postDep.setCreatedAt(posts.getCreatedAt());
        }
        if (Objects.nonNull(posts.getUpdatedAt())){
            postDep.setUpdatedAt(posts.getUpdatedAt());
        }
        return postDep;
    }


}
