package com.springdemoaop.bloggingapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postId;

    private String title;

    private String content;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Users users;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

//Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(new Date().getTime());
//        calendar.add(Calendar.MINUTE, expirationTime);
//        return new Date(calendar.getTime().getTime());
