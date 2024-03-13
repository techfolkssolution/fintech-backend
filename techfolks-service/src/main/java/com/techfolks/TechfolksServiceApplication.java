package com.techfolks;

import com.techfolks.entity.User;
import com.techfolks.enums.Gender;
import com.techfolks.repository.UserReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;


@SpringBootApplication
public class TechfolksServiceApplication implements CommandLineRunner {

    @Autowired
    private UserReposiotry userReposiotry;

    public static void main(String[] args) {
        SpringApplication.run(TechfolksServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = userReposiotry.findUserByEmail("admin@gmail.com");
        if (user == null) {
            User userEntity = new User();
            userEntity.setEmail("admin@gmail.com");
            userEntity.setGender(Gender.MALE);
            userEntity.setFirstName("admin");
            userEntity.setLastName("local");
            userEntity.setDob(LocalDate.parse("2000-08-12"));
            userEntity.setAddress("Local Address");
            userEntity.setCreateBy(1);
            userEntity.setUpdatedBy(0);
            userEntity.setPassword("admin");
            userReposiotry.save(userEntity);
        }
    }
}

