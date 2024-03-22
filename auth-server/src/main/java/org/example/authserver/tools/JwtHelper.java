package org.example.authserver.tools;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


public class JwtHelper {
    public static final String AUTHZ_CODE_SECRET = "aV5aa6J99Nalrv6piMR7dOqgYhWKU5H2fw1s6VvYeBEFn";
    public static final String ACCESS_TOKEN_SECRET = "AFD8CptmvjzjFj255ojfgIVwDu1AcH5JkopndJow2shppbxkOh";

    public static String generateCodeAuthorization(String scope) {
        Date now = new Date();
        Date expired = new Date(now.getTime() + 300000);
        SecretKey key = Keys.hmacShaKeyFor(AUTHZ_CODE_SECRET.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder()
                .setIssuer("Nashtech")
                .setSubject("Code Authorization")
                .claim("scope", scope)
                .setIssuedAt(now)
                .setIssuedAt(expired)
                .signWith(key)
                .compact();
        return jwt;
    }

    public static List<String> generateAccessToken(String scope) {
        List<String> jwt = new ArrayList<>();
        Date now = new Date();
        Date expired = new Date(now.getTime() + 300000);
        SecretKey key = Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder()
                .setIssuer("Nashtech")
                .setSubject("Access Token")
                .claim("scope", scope)
                .setIssuedAt(now)
                .setExpiration(expired)
                .signWith(key)
                .compact();
        jwt.add(token);
        jwt.add(expired.toString());
        return jwt;
    }

    public static String verifyCodeAuthorization(String code)
            throws MalformedJwtException,
            ExpiredJwtException,
            UnsupportedJwtException,
            IllegalArgumentException {
        Claims claims = Jwts.parser()
                .setSigningKey(AUTHZ_CODE_SECRET.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(code)
                .getBody();
        return claims.get("scope").toString();
    }
}
