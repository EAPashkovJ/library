package ru.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import ru.library.repository.UserRepository;
import ru.library.service.JWTFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
@Configuration
@Order(1000)
public class WebSecurityConfiguration extends
        WebSecurityConfigurerAdapter {

        private final UserRepository userRepository;
        private final JWTFilter jwtTokenFilter;

    public WebSecurityConfiguration(UserRepository userRepository, JWTFilter jwtTokenFilter) {
        this.userRepository = userRepository;
        this.jwtTokenFilter = jwtTokenFilter;
    }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Enable CORS and disable CSRF
            http = http.cors().and().csrf().disable();

            // Set session management to stateless
            http = http
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and();

            // Set unauthorized requests exception handler
            http = http
                    .exceptionHandling()
                    .authenticationEntryPoint(
                            (request, response, ex) -> {
                                response.sendError(
                                        HttpServletResponse.SC_UNAUTHORIZED,
                                        ex.getMessage()
                                );
                            }
                    )
                    .and();

            // Set permissions on endpoints
            http.authorizeRequests()
                    // Our public endpoints
                    .antMatchers("/api/public/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/author/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/author/search").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/book/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/book/search").permitAll()
                    // Our private endpoints
                    .anyRequest().authenticated();

            // Add JWT token filter
            http.addFilterBefore(
                    jwtTokenFilter,
                    UsernamePasswordAuthenticationFilter.class
            );
        }

        // Used by Spring Security if CORS is enabled.
        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source =
                    new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.addAllowedOrigin("*");
            config.addAllowedHeader("*");
            config.addAllowedMethod("*");
            source.registerCorsConfiguration("/**", config);
            return new CorsFilter(source);
        }

    }