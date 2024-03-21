package com.techfolks.service;

import com.techfolks.request.UserDetailsRequest;
import com.techfolks.response.UserDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService {
    UserDetailsResponse createUserDetails(UserDetailsRequest userDetailsRequest);

}
