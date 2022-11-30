package ru.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.library.service.UserDetailsServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("ru.library")
public class SpringConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsServiceImpl;



        @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

}
