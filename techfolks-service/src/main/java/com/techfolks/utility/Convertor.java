package com.techfolks.utility;

import com.techfolks.entity.User;
import com.techfolks.entity.UserDetails;
import com.techfolks.request.UserDetailsRequest;
import com.techfolks.response.UserDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Convertor {

    public UserDetails requestToEntity(UserDetailsRequest userDetailsRequest) {
        return UserDetails.builder().email(userDetailsRequest.getEmail())
                .firstName(userDetailsRequest.getFirstName())
                .lastName(userDetailsRequest.getLastName())
                .gender(userDetailsRequest.getGender())
                .address(userDetailsRequest.getAddress())
                .dob(userDetailsRequest.getDob())
                .build();
    }

    public UserDetailsResponse entityToResponse(UserDetails userDetails) {
        return UserDetailsResponse.builder().id(userDetails.getId())
                .email(userDetails.getEmail())
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .gender(userDetails.getGender())
                .address(userDetails.getAddress())
                .dob(userDetails.getDob())
                .userId(userDetails.getUserId().getUserId())
                .build();
    }

    public UserDetails updateEntity(UserDetailsRequest userDetailsRequest, UserDetails userDetails) {
        return UserDetails.builder().id(userDetails.getId())
                .email(userDetailsRequest.getEmail())
                .firstName(userDetailsRequest.getFirstName())
                .lastName(userDetailsRequest.getLastName())
                .gender(userDetailsRequest.getGender())
                .address(userDetailsRequest.getAddress())
                .dob(userDetailsRequest.getDob())
                .build();

    }

    public User userIdFromRequest(UserDetailsRequest userDetailsRequest) {
        User user = new User();
        user.setUserId(userDetailsRequest.getUserId());
        return user;
    }
}
