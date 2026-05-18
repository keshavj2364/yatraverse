package com.yatraverse.config;

import com.cloudinary.Cloudinary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        Map<String, String> config =
        new HashMap<>();

        config.put(
            "cloud_name",
            "dln1kg3ju"
        );

        config.put(
            "api_key",
            "914319151232482"
        );

        config.put(
            "api_secret",
            "ueKBN3Q2CYbkcjL-4CHO-z2kp04"
        );

        return new Cloudinary(config);
    }
}