package com.techfolks.entity;

import com.techfolks.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user_userId;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "dob",nullable = false)
    private LocalDate dob;

    @CreationTimestamp
    @Column(name = "createdOn",nullable = false)
    private LocalDate createdOn;

    @Column(name = "createdBy",nullable = false)
    private Integer createBy;

    @Column(name = "updatedBy",nullable = false)
    private int updatedBy;

    @UpdateTimestamp
    @Column(name = "updatedOn",nullable = false)
    private LocalDateTime updatedOn;
}
