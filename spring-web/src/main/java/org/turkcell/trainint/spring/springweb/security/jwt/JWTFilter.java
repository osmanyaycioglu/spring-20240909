package org.turkcell.trainint.spring.springweb.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.turkcell.trainint.spring.springweb.security.MyUserDetailService;

import java.io.IOException;


@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTService          jwtService;
    private final MyUserDetailService myUserDetailService;

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        String authorizationLoc = request.getHeader("Authorization");
        if (authorizationLoc == null || !authorizationLoc.startsWith("Bearer")) {
            filterChain.doFilter(request,
                                 response);
            return;
        }
        String token = authorizationLoc.substring(7);

        Jws<Claims> claims = jwtService.validate(token);
        if (claims == null) {
            response.setStatus(401);
            response.getWriter()
                    .println("Token is not valid");
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            return;
        }
        Claims      payloadLoc     = claims.getPayload();
        String      subjectLoc     = payloadLoc.getSubject();
        UserDetails userDetailsLoc = myUserDetailService.loadUserByUsername(subjectLoc);

        if (userDetailsLoc == null) {
            response.setStatus(401);
            response.getWriter()
                    .println("User is not valid");
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            return;
        }

        Authentication authenticationLoc = new UsernamePasswordAuthenticationToken(userDetailsLoc.getUsername(),
                                                                                   userDetailsLoc.getPassword(),
                                                                                   userDetailsLoc.getAuthorities());
        SecurityContextHolder.getContext()
                             .setAuthentication(authenticationLoc);
        filterChain.doFilter(request,
                             response);
    }
}
