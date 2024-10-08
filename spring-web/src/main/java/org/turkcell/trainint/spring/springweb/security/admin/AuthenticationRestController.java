package org.turkcell.trainint.spring.springweb.security.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.turkcell.trainint.spring.springweb.security.jwt.JWTService;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationRestController {
    private final AuthenticationProvider authenticationProvider;
    private final JWTService             jwtService;

    @GetMapping("/login")
    public String login(String username,
                        String password) {
        Authentication authenticationLoc = new UsernamePasswordAuthenticationToken(username,
                                                                                   password);

        Authentication authenticateLoc = authenticationProvider.authenticate(authenticationLoc);
        if (authenticateLoc == null) {
            throw new SecurityException("Authentication problem");
        }
        return jwtService.createToken(username);
    }
}
