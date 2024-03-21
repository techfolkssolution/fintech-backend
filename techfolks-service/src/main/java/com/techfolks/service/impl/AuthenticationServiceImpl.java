package com.techfolks.service.impl;

import com.techfolks.entity.User;
import com.techfolks.repository.UserReposiotry;
import com.techfolks.request.LoginReq;
import com.techfolks.request.SignUpRequest;
import com.techfolks.response.ErrorRes;
import com.techfolks.response.LoginRes;
import com.techfolks.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techfolks.service.AuthenticationService;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserReposiotry userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> signUp(SignUpRequest signUpRequest) {
        try {
            User existingUser = userRepository.findUserByPhoneNumber(signUpRequest.getPhoneNumber());
            if (existingUser != null) {
                throw new RuntimeException("User With This Phone Number Already Exists");
            }
            String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
            User newUser = new User(signUpRequest.getPhoneNumber(), encodedPassword);
            userRepository.save(newUser);
            return ResponseEntity.ok("User Signed Up Successfully");

        } catch (RuntimeException runtimeException) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "User With This Phone Number Already Exists");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception exception) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Error Signing Up user");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @Override
    public ResponseEntity<?> login(LoginReq loginReq) {
        try {
            User existingUser = userRepository.findUserByPhoneNumber(loginReq.getPhoneNumber());
            if (existingUser != null) {
                if (passwordEncoder.matches(loginReq.getPassword(), existingUser.getPassword())) {
                    Authentication authentication = authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(loginReq.getPhoneNumber(), loginReq.getPassword()));
                    String phoneNumber = authentication.getName();
                    String token = jwtUtil.createToken(existingUser);
                    LoginRes loginRes = new LoginRes(phoneNumber, token);
                    return ResponseEntity.ok(loginRes);
                } else {
                    throw new BadCredentialsException("Invalid username or password");
                }
            } else {
                throw new BadCredentialsException("User not found");
            }

        } catch (BadCredentialsException exception) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.UNAUTHORIZED, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } catch (Exception exception) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "An error occurred while processing your request.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
