package com.table2table.security.service.impl;

import com.table2table.security.dto.CustomUserDetailsDto;
import com.table2table.security.dto.UserResponseDto;
import com.table2table.security.service.IUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

    private final WebClient.Builder webClientBuilder;

    public UserDetailsServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        String userServiceUrl = "http://user-service/api/users/getUserByEmail/";
        UserResponseDto userCred =  webClientBuilder.build()
                .get()
                .uri(userServiceUrl + "{email}", username)
                .retrieve()
                .bodyToMono(UserResponseDto.class)
                .block();
        userCred.setRole("ROLE_"+ userCred.getRole());
        return new CustomUserDetailsDto(userCred); // ✅ injects role like "ADMIN"
    }
}
