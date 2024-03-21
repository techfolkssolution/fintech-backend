package com.techfolks.controller;

import com.techfolks.utility.Convertor;
import com.techfolks.entity.User;
import com.techfolks.request.UserDetailsRequest;
import com.techfolks.response.UserDetailsResponse;
import com.techfolks.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/user")
public class UserDetailsController {

    private final Convertor convertor;

    private final UserDetailsService userDetailsService;

    @PostMapping("/userdetails")
    public ResponseEntity<UserDetailsResponse> createUserDetails(@RequestBody UserDetailsRequest request) {
        try {
            User user = convertor.userIdFromRequest(request);
            UserDetailsResponse response = userDetailsService.createUserDetails(request);
            response.setUserId(user.getUserId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
