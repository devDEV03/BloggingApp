package com.springdemoaop.bloggingapp.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userEmail","username"})
        }
)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "username")
    private String username;

    private String password;

    @Column(name = "userEmail")
    private String email;

}
