package com.springdemoaop.bloggingapp.repository;

import com.springdemoaop.bloggingapp.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface commentRepository extends JpaRepository<Comments,Long> {
}
