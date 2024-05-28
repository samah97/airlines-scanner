package com.sd.airlinesscanner.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Getter
@Setter
public class AirlineProviderConfig {


    @Value("${airline-providers}")
    private List<String> providersList;
}
