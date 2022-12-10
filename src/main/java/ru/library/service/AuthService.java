package ru.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.library.domain.dto.JwtResponse;
import ru.library.domain.dto.LoginRequest;
import ru.library.security.JWTUtil;
import ru.library.security.UserDetailsImpl;

@Service
@RequiredArgsConstructor
@Transactional()
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;


    public JwtResponse authenticateUser(LoginRequest authBody) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authBody.getName(), authBody.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return JwtResponse.builder()
                .token(token)
                .build();
    }
}
