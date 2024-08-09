package com.springdemoaop.bloggingapp.repository;

import com.springdemoaop.bloggingapp.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<Users,Long> {
}
