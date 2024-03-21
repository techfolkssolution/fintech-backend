package com.techfolks.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String phoneNumber, password;
}
