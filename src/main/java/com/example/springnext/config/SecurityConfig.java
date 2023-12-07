package com.example.springnext.config;

import com.example.springnext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ContentSecurityPolicyHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Configuration
public class SecurityConfig extends AbstractHttpConfigurer<SecurityConfig, HttpSecurity> {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    // Skapar en bean för AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Konfigurerar autentisering med UserService och PasswordEncoder
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    // Konfigurerar säkerhetsfilter och åtkomstregler
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Inaktiverar CSRF-skydd
                .authorizeRequests(authz -> authz
                        .requestMatchers(new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/register"),
                                new AntPathRequestMatcher("/users"),
                                new AntPathRequestMatcher("/folders/**"),
                                new AntPathRequestMatcher("/files/**")).permitAll() // Tillåter obegränsad åtkomst till vissa vägar
                        .anyRequest().authenticated()) // Kräver autentisering för alla andra förfrågningar
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Anpassad inloggningssida
                        .permitAll()
                        .defaultSuccessUrl("/home", true)) // Omdirigerar till /home efter lyckad inloggning
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout").permitAll()); // Hanterar utloggning
        return http.build();
    }

}

