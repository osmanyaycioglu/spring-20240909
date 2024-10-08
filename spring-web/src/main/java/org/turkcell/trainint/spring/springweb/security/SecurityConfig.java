package org.turkcell.trainint.spring.springweb.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.turkcell.trainint.spring.springweb.security.jwt.JWTFilter;
import org.turkcell.trainint.spring.springweb.security.jwt.JWTService;
import org.turkcell.trainint.spring.springweb.security.models.IInternalUserRepository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final IInternalUserRepository userRepository;

    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter(jwtService(),
                             myUserDetailService());
    }

    @Bean
    public JWTService jwtService() {
        return new JWTService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyUserDetailService myUserDetailService() {
        return new MyUserDetailService(userRepository,
                                       passwordEncoder());
    }

    @Bean
    public AuthenticationProvider authenticationProvider(MyUserDetailService detailServiceParam) {
        DaoAuthenticationProvider providerLoc = new DaoAuthenticationProvider();
        providerLoc.setPasswordEncoder(passwordEncoder());
        providerLoc.setUserDetailsService(detailServiceParam);
        return providerLoc;
    }

    @Bean
    public SecurityFilterChain myWebSecurity(HttpSecurity httpSecurityParam) throws Exception {
        return httpSecurityParam.csrf(CsrfConfigurer::disable)
                                .cors(CorsConfigurer::disable)
                                .authorizeHttpRequests(a -> a.requestMatchers("/actuator/**",
                                                                              "/authentication/**")
                                                             .anonymous()
                                                             .requestMatchers("/admin/**")
                                                             .hasAnyAuthority("SUPER_ADMIN",
                                                                              "ADMIN")
                                                             .anyRequest()
                                                             .authenticated())
                                .addFilterBefore(jwtFilter(),
                                                 UsernamePasswordAuthenticationFilter.class)
                                .formLogin(FormLoginConfigurer::disable)
                                .httpBasic(HttpBasicConfigurer::disable)
                                .sessionManagement(SessionManagementConfigurer::disable)
                                .headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                                .build();
    }

}
