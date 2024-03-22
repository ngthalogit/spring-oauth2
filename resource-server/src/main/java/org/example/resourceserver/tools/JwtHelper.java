package org.example.resourceserver.tools;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JwtHelper {
    public static Logger LOGGER = LoggerFactory.getLogger(JwtHelper.class);
    public static final String ACCESS_TOKEN_SECRET = "AFD8CptmvjzjFj255ojfgIVwDu1AcH5JkopndJow2shppbxkOh";

    public static String verifyCodeAuthorization(String code)
            throws MalformedJwtException,
            UnsupportedJwtException,
            IllegalArgumentException,
            ExpiredJwtException {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(code)
                    .getBody();
            return claims.get("scope").toString();
        } catch (MalformedJwtException e) {
            LOGGER.info("Invalid JWT");
        } catch (ExpiredJwtException e) {
            LOGGER.info("Expired JWT");
        } catch (UnsupportedJwtException e) {
            LOGGER.info("Unsupported JWT");
        } catch (IllegalArgumentException e) {
            LOGGER.info("JWT claims string is empty.");
        }
        return null;
    }

    public static String getAuthorizationHeader(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }
}
