package com.techfolks.service.impl;

import com.techfolks.utility.Convertor;
import com.techfolks.entity.User;
import com.techfolks.entity.UserDetails;
import com.techfolks.repository.UserDetailsRepository;
import com.techfolks.repository.UserReposiotry;
import com.techfolks.request.UserDetailsRequest;
import com.techfolks.response.UserDetailsResponse;
import com.techfolks.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserReposiotry userReposiotry;

    private final UserDetailsRepository userDetailsRepository;

    private final Convertor convertor;


    @Override
    public UserDetailsResponse createUserDetails(UserDetailsRequest userDetailsRequest) {
        User user = userReposiotry.findById(userDetailsRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userDetailsRequest.getUserId()));
        UserDetails userDetails = convertor.requestToEntity(userDetailsRequest);
        userDetails.setUserId(user);
        UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
        return convertor.entityToResponse(savedUserDetails);
    }
}
