package com.techfolks.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRes {
    HttpStatus httpStatus;
    String message;

}
