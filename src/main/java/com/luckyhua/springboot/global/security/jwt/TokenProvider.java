package com.luckyhua.springboot.global.security.jwt;

import com.luckyhua.springboot.global.config.JHipsterProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author luckyhua
 * @date 2016/11/11
 * @description make token and manager
 */
@Component
public class TokenProvider {

    private static final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY = "auth";

    @Autowired
    private JHipsterProperties jHipsterProperties;

    private String secretKey;
    private long tokenValidityInSeconds;

    @PostConstruct
    public void init() {
        this.secretKey = jHipsterProperties.getSecurity().getJwt().getSecret();
        this.tokenValidityInSeconds = 1000 * jHipsterProperties.getSecurity().getJwt().getTokenValidityInSeconds();
        log.info("ZGH01130: token provider init secretKey = {}, tokenValidityInSeconds = {}", secretKey, tokenValidityInSeconds);
    }

    public String createToken(Integer userId) {

        if (userId == null) {
            return null;
        }

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInSeconds);

        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim(AUTHORITIES_KEY, String.valueOf(userId))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(validity)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            //invalid jwt out time and security
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            log.info("Invalid JWT signature: " + e.getMessage());
            return false;
        }
    }

    public Integer getUserIdByToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        this.validateToken(token);
        return Integer.valueOf(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());
    }

}
