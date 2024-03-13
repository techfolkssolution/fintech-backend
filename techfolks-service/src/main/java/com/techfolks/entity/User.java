package com.techfolks.entity;

import com.techfolks.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "dob",nullable = false)
    private LocalDate dob;

    @CreationTimestamp
    @Column(name = "createdOn",nullable = false)
    private LocalDate createdOn;

    @Column(name = "createdBy",nullable = false)
    private Integer createBy;

    @Column(name = "updatedby",nullable = false)
    private int updatedBy;

    @UpdateTimestamp
    @Column(name = "updatedon",nullable = false)
    private LocalDateTime updatedOn;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
