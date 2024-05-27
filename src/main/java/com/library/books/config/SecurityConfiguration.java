/*
 * package com.library.books.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableMethodSecurity public class SecurityConfiguration {
 * 
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception { http .authorizeHttpRequests((authz) -> authz
 * .anyRequest().authenticated() ); return http.build(); }
 * 
 * }
 */