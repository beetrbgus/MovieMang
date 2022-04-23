package com.moviemang.security.service;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

@Component
@Slf4j
public class AuthenticationService {

    private static long REFRESH_TOKEN_VALID_SECONDS = 60 * 60 * 24 * 30; // default 30 days.
    private static long ACCESS_TOKEN_VALID_SECONDS = 60 * 60 * 12; // default 12 hours.
    static final String SIGNINGKEY = "moviemang-key";
    static final String BEARER_PREFIX = "Bearer";

    static public void creatJwtToken(HttpServletResponse response, String username) {
        Claims claims = Jwts.claims();
        claims.put("username", username);
//        String accessJwtToken = Jwts.builder().setSubject(username)
        String accessJwtToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALID_SECONDS))
                .signWith(SignatureAlgorithm.HS256, SIGNINGKEY)
                .compact();

        response.addHeader("Authorization", BEARER_PREFIX + " " + accessJwtToken);
        response.addHeader("refresh_token",  createRefreshToken(username));
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public String createRefreshToken(String username){
        Claims claims = Jwts.claims();
        claims.put("username", username);
        String refreshJwtToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALID_SECONDS))
                .signWith(SignatureAlgorithm.HS256, SIGNINGKEY)
                .compact();
        return refreshJwtToken;
    }

    public boolean validateJwtToken(String accessToken){
        try {
            Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(accessToken);
            return true;
        } catch (SignatureException e){
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(BEARER_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            } else {
                throw new RuntimeException("Authentication failed");
            }
        }
        return null;
    }
}
