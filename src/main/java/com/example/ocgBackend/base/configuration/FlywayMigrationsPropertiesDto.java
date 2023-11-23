package com.example.ocgBackend.base.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlywayMigrationsPropertiesDto {
    private String schema;
    private String location;
    private Boolean clean;
    private Boolean runDefaultCallbacks;
}
