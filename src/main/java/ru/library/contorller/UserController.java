package ru.library.contorller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.library.domain.User;
import ru.library.domain.dto.JwtResponse;
import ru.library.domain.dto.LoginRequest;
import ru.library.domain.dto.UserBasicInfoDTO;
import ru.library.domain.dto.UserRegistrationDTO;
import ru.library.security.JWTUtil;
import ru.library.security.UserValidator;
import ru.library.service.AuthService;
import ru.library.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final ModelMapper modelMapper;
    private final UserValidator userValidator;
    private final JWTUtil jwtUtil;
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest authBody) {
        JwtResponse jwtResponse = authService.authenticateUser(authBody);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/registration")
    public Map<String, String> registration(@Valid @RequestBody UserRegistrationDTO registrationDTO,
                                            BindingResult bindingResult) {
        User user = modelMapper.map(registrationDTO, User.class);

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return Map.of("message", "User invalid");
        }

        userServiceImpl.register(user);

        String token = jwtUtil.generateToken(user.getName());
        return Map.of("jwt-token", token);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/show")
    public List<UserBasicInfoDTO> findAllUsers() {
        List<UserBasicInfoDTO> userBasicInfoDTOS = userServiceImpl.findAllUserWithBasicInfo();
        return userBasicInfoDTOS;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userServiceImpl.findById(id);

    }


}
