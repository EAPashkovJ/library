package ru.library.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.library.domain.Role;
import ru.library.domain.User;
import ru.library.domain.dto.UserBasicInfoDTO;
import ru.library.domain.enums.UserAccessType;
import ru.library.repository.RoleRepository;
import ru.library.repository.UserRepository;

import javax.persistence.AccessType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final User user;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(User user, UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.user = user;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
        Set<Role> roleSet = user.getUserAccessType();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> roleOptional;
        if (("admin").equals(user.getName())) {
            roleOptional = roleRepository.findByRole(UserAccessType.ADMIN);
        } else {
            roleOptional = roleRepository.findByRole(UserAccessType.USER);
        }
        roleOptional.ifPresent(roleSet::add);
        userRepository.save(user);
    }


}
