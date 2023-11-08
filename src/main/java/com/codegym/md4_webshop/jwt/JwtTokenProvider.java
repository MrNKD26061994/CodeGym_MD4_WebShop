package com.codegym.md4_webshop.jwt;


import com.codegym.md4_webshop.model.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
@Slf4j
@Service
public class JwtTokenProvider {
    @Value("${com.codegym.md4_webshop.jwt.secret}")
    private String JWT_SECRET;
    @Value("${com.codegym.md4_webshop.jwt.expiration}")
    private  int JWT_EXPIRATION;
    //Tạo jwt token từ thông tin user
    public String generateToken (Authentication authentication) {
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + JWT_EXPIRATION);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        //Tạo chuỗi JSON WEB TOKEN từ userName của user
        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
    //Lấy thông tin user từ jwt
    public String getUserNameFromJwt (String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    //Validate thông tin của jwt
    public boolean validateToken (String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT Token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT Token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT Token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims String is empty");
        }
        return false;
    }
}
