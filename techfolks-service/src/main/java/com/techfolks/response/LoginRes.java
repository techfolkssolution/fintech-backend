package com.techfolks.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {

    private String phoneNumber, token;
}