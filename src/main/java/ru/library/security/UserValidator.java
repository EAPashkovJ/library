package ru.library.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.library.domain.User;
import ru.library.domain.enums.UserAccessType;
import ru.library.service.UserDetailsServiceImpl;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserAccessType.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        try {
            userDetailsService.loadUserByUsername(user.getName());
        } catch (UsernameNotFoundException ignore) {
            return;
        }

        errors.rejectValue("username", "", "User ---");
    }
}
