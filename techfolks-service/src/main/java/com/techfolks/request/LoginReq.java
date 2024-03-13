package com.techfolks.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {
    private String email;
    private String password;

}
