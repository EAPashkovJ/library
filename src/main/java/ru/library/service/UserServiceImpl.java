package ru.library.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.library.domain.User;
import ru.library.domain.dto.UserBasicInfoDTO;
import ru.library.domain.enums.UserAccessType;
import ru.library.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final User user;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(User user, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.user = user;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserBasicInfoDTO> findAllUserWithBasicInfo() {
        return userRepository.findAllUserWithBasicInfo();
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public UserBasicInfoDTO findUserBasicInfoById(long id) {
        return userRepository.findUserBasicInfoById(id);
    }
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserAccessType(Collections.singleton(UserAccessType.USER));
        userRepository.save(user);
    }
}
