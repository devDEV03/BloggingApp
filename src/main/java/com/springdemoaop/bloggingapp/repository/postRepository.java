package com.springdemoaop.bloggingapp.repository;

import com.springdemoaop.bloggingapp.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface postRepository extends JpaRepository<Posts,Long> {
}
