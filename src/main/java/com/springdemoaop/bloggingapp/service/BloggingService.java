package com.springdemoaop.bloggingapp.service;


import com.springdemoaop.bloggingapp.entity.Comments;
import com.springdemoaop.bloggingapp.entity.Posts;
import com.springdemoaop.bloggingapp.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BloggingService {
    Users saveUsers(Users users);

    Posts savePosts(Posts posts);

    Comments saveComments(Comments comments);

    Users getUserById(Long userId);

    Posts getPostById(Long postId);

    Comments getCommentById(Long commentId);

    List<Users> getAllUsers();

    List<Posts> getAllPosts();

    List<Comments> getAllComments();

    void deleteUser(Long userId);

    void deleteComment(Long commentId);

    void deletePost(Long postId);

    Users setUser(Long userId, Users users);

    Posts setPosts(Long postId, Posts posts);

    Comments setComments(Long commentId, Comments comments);
}
