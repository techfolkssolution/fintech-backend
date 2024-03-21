package com.techfolks.response;

import com.techfolks.entity.User;
import com.techfolks.enums.Gender;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserDetailsResponse {

    private Long id;

    private String email, firstName, lastName, address;

    private Gender gender;

    private LocalDate dob;

    private Long userId;

}
