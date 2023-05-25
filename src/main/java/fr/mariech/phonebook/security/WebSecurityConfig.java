package fr.mariech.phonebook.security;

import fr.mariech.phonebook.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    UserDetailsService customUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService());
        return provider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            //.csrf().disable()
            //.cors().disable()
            .authorizeHttpRequests(requests -> {
                requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/users/**").permitAll()
                    .anyRequest().authenticated();

            }).formLogin(form -> {
                form
                    .loginPage("/login")
                    .usernameParameter("email")    // <input name="email">
                    .passwordParameter("password") // <input name="password">
                    .defaultSuccessUrl("/auth/profile")
                    .permitAll(); // permitAll = accessible sans que l'on ne soit connecté
            }).logout(logout -> {
                logout
                    .logoutUrl("/logout");
            }).build();
    }


}