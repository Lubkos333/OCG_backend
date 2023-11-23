package com.example.ocgBackend.base.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "flyway-migrations")
public class FlywayMigrationsProperties {
    private List<FlywayMigrationsPropertiesDto> migrations;
}
