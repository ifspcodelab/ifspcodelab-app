package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizeConfig -> {
                    authorizeConfig.requestMatchers("/").permitAll();
                    authorizeConfig.requestMatchers("/error").permitAll();
                    authorizeConfig.requestMatchers("/icon.ico").permitAll();
                    authorizeConfig.requestMatchers("/selections/*/applications/submit").permitAll();
                    authorizeConfig.requestMatchers("/selections/*/applications/success").permitAll();
                    authorizeConfig.requestMatchers("/admin").hasRole("ADMIN");
                    authorizeConfig.anyRequest().authenticated();
                })
                .oauth2Login(t -> t.successHandler(oAuth2SuccessHandler()))
                .build();
    }

    public OAuth2SuccessHandler oAuth2SuccessHandler() {
        return new OAuth2SuccessHandler();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("user")
                        .password("{noop}password")
                        .authorities("ROLE_USER")
                        .build()
        );
    }
}
