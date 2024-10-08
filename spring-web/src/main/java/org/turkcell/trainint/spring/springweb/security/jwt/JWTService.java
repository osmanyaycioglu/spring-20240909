package org.turkcell.trainint.spring.springweb.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;


public class JWTService {
    private Key key;

    public JWTService() {
        key = Keys.hmacShaKeyFor("dghjaskdjajlhdaljshdgkasjhdgakhsdgahdgasdasd".getBytes());
    }

    public String createToken(String username) {
        return Jwts.builder()
                   .subject(username)
                   .issuedAt(new Date())
                   .expiration(Date.from(ZonedDateTime.now()
                                                      .plusHours(1)
                                                      .toInstant()))
                   .signWith(key)
                   .claim("ip",
                          "192.168.1.1")
                   .compact();
    }

    public Jws<Claims> validate(String token) {
        JwtParser jwtParserLoc = Jwts.parser()
                                     .setSigningKey(key)
                                     .build();
        try {
            Jws<Claims> claimsJwsLoc = jwtParserLoc.parseSignedClaims(token);
            return claimsJwsLoc;
        } catch (Exception eParam) {
            eParam.printStackTrace();
            return null;
        }
    }

}

