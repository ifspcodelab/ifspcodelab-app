package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.authentication;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var accountOpenPaths = List.of(
                "/",
                "/selections/*/applications/submit",
                "/selections/*/applications/success"
        );

        return http
                .authorizeHttpRequests(authorizeConfig -> {
                    authorizeConfig.requestMatchers(accountOpenPaths.toArray(String[]::new)).permitAll();
                    authorizeConfig.requestMatchers("/admin").hasRole("ADMIN");
                    authorizeConfig.anyRequest().authenticated();
                })
                .oauth2Login(t -> t.successHandler(oAuth2SuccessHandler))
                .build();
    }

//    @Bean
//    public OAuth2SuccessHandler oAuth2SuccessHandler(ApplicationRepository applicationRepository,
//                                                     StudentRepository studentRepository) {
//        return new OAuth2SuccessHandler(applicationRepository, studentRepository);
//    }

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
