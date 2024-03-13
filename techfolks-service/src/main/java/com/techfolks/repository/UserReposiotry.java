package com.techfolks.repository;

import com.techfolks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReposiotry extends JpaRepository<User, Long> {

    @Query(value = "select * from user where email= :email", nativeQuery = true)
    public User findUserByEmail(String email);
}

