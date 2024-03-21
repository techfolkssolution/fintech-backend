package com.techfolks.service;

import com.techfolks.request.LoginReq;
import com.techfolks.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    ResponseEntity<?> login(LoginReq loginReq);

    ResponseEntity<?> signUp(SignUpRequest signUpRequest);
}
