package com.luckyhua.springboot.global.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luckyhua
 * @date 2016/11/11
 * @description
 */
@ConfigurationProperties(prefix="security", ignoreUnknownFields = false)
@Component
public class Security {

    private final Jwt jwt = new Jwt();

    public Jwt getJwt() {
        return jwt;
    }

    public static class Jwt {

        private String secret;

        private long tokenValidityInSeconds = 1800;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public long getTokenValidityInSeconds() {
            return tokenValidityInSeconds;
        }

        public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
            this.tokenValidityInSeconds = tokenValidityInSeconds;
        }
    }
}
