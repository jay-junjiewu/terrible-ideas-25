package com.au.iroqquois.terrible_messsanger.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class JWTConfig {

    @Value("${security.jwt.secret}")
    private String secretKey;
}
