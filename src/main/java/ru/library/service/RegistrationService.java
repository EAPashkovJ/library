package ru.library.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.library.domain.User;
import ru.library.domain.enums.UserAccessType;
import ru.library.repository.UserRepository;

import java.util.Collections;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getName());
        if (userFromDb != null) {
            return false;
        }
        user.setUserAccessType(Collections.singleton(UserAccessType.USER));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
