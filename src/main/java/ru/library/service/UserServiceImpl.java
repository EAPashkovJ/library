package ru.library.service;

import org.springframework.stereotype.Service;
import ru.library.domain.User;
import ru.library.domain.dto.UserBasicInfoDTO;
import ru.library.domain.enums.UserAccessType;
import ru.library.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final User user;
    private final UserRepository userRepository;

    public UserServiceImpl(User user, UserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
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

    public void save(String username,
                     int points,

                     String email,
                     String password) {

        user.setName(username);
        user.setPoints(points);
        user.setUserAccessType(Collections.singleton(UserAccessType.USER));
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);


    }



}
