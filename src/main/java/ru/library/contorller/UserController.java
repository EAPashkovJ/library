package ru.library.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.library.domain.User;
import ru.library.domain.dto.UserBasicInfoDTO;
import ru.library.domain.enums.UserAccessType;
import ru.library.service.UserService;
import ru.library.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/show")
    public List<UserBasicInfoDTO> findAllUsers () {
        List<UserBasicInfoDTO> userBasicInfoDTOS = userServiceImpl.findAllUserWithBasicInfo();
        return userBasicInfoDTOS;
    }

    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userServiceImpl.findById(id);

    }

    // Нужно в запросе как-то прописать пользователя для вставки в таблицу
    @PostMapping("/save")
    public HttpStatus save (@RequestParam(value = "username") String username,
                            @RequestParam(value = "points") int points,

                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "password") String password) {

        userServiceImpl.save(username, points, email,password);
        return HttpStatus.OK;
    }


}
