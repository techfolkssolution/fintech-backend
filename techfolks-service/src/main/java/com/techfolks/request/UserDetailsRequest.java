package com.techfolks.request;

import com.techfolks.entity.User;
import com.techfolks.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserDetailsRequest {

    private String email, firstName,lastName, address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dob;

    private Long userId;

}
