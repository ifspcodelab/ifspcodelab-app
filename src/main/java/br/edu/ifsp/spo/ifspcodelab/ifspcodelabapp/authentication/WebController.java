package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class WebController {
    @GetMapping("/")
    public String publicPage() {
        return "Hello world";
    }

    @GetMapping("/private")
    public String privatePage(Authentication authentication) {
        return "Welcome to the VIP room ~[" +
                getName(authentication) +
                " ]~ ";
    }

    @GetMapping("/admin")
    public String privateAdmin(Authentication authentication) {
        return "Welcome to the VIP room ~[" +
                getName(authentication) +
                " ]~ ";
    }

    private static String getName(Authentication authentication) {
        return Optional.of(authentication.getPrincipal())
                .filter(OidcUser.class::isInstance)
                .map(OidcUser.class::cast)
                .map(OidcUser::getEmail)
                .orElseGet(authentication::getName);
    }
}
