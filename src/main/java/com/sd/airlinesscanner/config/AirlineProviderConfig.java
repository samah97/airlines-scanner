package com.sd.airlinesscanner.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "airline-providers")
@Getter
@Setter
public class AirlineProviderConfig {

    @Value("${airline-providers}")
    private List<String> airlineProviders;
    private TurkishProviderConfig turkish;


    @Getter
    @Setter
    public static class TurkishProviderConfig{
            private String apiKey;
            private String apiSecret;
    }

}
