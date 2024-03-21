package com.techfolks;

import com.techfolks.entity.User;
import com.techfolks.enums.Gender;
import com.techfolks.repository.UserReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@SpringBootApplication
public class TechfolksServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechfolksServiceApplication.class, args);
    }

}

