package ru.library.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.library.service.UserDetailsServiceImpl;

import javax.sql.DataSource;

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
    @Autowired
    private DataSource dataSource;
    @Autowired

    private  PasswordEncoder passwordEncoder;

    @Autowired

    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema()
                .withUser("user").password(passwordEncoder.encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("password")).roles("USER", "ADMIN");
    }
//@Bean
//public PasswordEncoder passwordEncoder() {
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//}

}
