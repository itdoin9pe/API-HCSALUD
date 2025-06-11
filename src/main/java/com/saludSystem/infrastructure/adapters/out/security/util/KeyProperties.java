package com.saludSystem.infrastructure.adapters.out.security.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "key.properties")
public class KeyProperties {

    List<Application> applications;

    @Data
    public static class Application {

        private String clientId;

        private String clientSecret;

    }

}
