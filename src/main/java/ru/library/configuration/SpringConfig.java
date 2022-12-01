package ru.library.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.library.service.UserDetailsServiceImpl;

@Configuration
@EnableWebMvc
public class SpringConfig {
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public SpringConfig(UserDetailsService userDetailsService) {
    }

    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
//@Bean
//public PasswordEncoder passwordEncoder() {
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//}

}
