package org.example.authserver.tools;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


public class JwtHelper {
    public static final String AUTHZ_CODE_SECRET = "$2a$12$KRBtQ72zMPsv0.pZlOMUa.Xqa8XriMVvu9JxDbQQgJOrzPseVezHu";
    public static final String ACCESS_TOKEN_SECRET = "$2a$12$FHosaFH3giYsopX0M/vIl.CNnZhFLPDchdbuCvs5hUB.JG4RfwH9.";
    public static String generateJwtToken(String scope) {
        Date now = new Date();
        Date expired = new Date(now.getTime() + 300000);
        SecretKey key = Keys.hmacShaKeyFor(AUTHZ_CODE_SECRET.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder()
                .setIssuer("Nashtech")
                .setSubject("Jwt")
                .claim("scope", scope)
                .setIssuedAt(now)
                .setIssuedAt(expired)
                .signWith(key)
                .compact();
        return jwt;
    }

}
