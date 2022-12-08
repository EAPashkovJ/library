package ru.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.library.domain.User;
import ru.library.domain.dto.JwtResponse;
import ru.library.domain.dto.LoginRequest;
import ru.library.domain.enums.UserAccessType;
import ru.library.repository.UserRepository;
import ru.library.security.JWTUtil;
import ru.library.security.UserDetailsImpl;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional()
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (("admin").equals(user.getName())) {
            user.setUserAccessType(UserAccessType.ADMIN);
        } else {
            user.setUserAccessType(UserAccessType.USER);
        }
        /*Wallet wallet = new Wallet();
        wallet.setBalance(0D);
        walletRepository.save(wallet);
        user.setWalletId(wallet.getId());*/
        userRepository.save(user);
    }

    public JwtResponse authenticateUser(LoginRequest authBody) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authBody.getName(), authBody.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        authenticationManager.authenticate(authInputToken);
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return JwtResponse.builder()
                .token(token)
                .build();
    }
}
