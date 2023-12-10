package com.example.ocgBackend.base.configuration;

import com.example.ocgBackend.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;

@Component
@Slf4j
public class MigrationStrategy implements FlywayMigrationStrategy {

    @Autowired
    private FlywayMigrationsProperties flywayMigrationProperties;

    @Override
    public void migrate(Flyway flywayDatasource){
        log.info("Running Flyway migrations");
        DataSource dataSource = flywayDatasource.getConfiguration().getDataSource();
        for (FlywayMigrationsPropertiesDto migration: flywayMigrationProperties.getMigrations()) {
            log.info("Running migration: {}", migration.toString());
            Boolean clean = Optional.ofNullable(migration.getClean()).orElse(false);
            Boolean defaultCallbacks = Optional.ofNullable(migration.getRunDefaultCallbacks()).orElse(false);
            Flyway flyway = Flyway.configure()
                    .schemas(migration.getSchema())
                    .locations(migration.getLocation())
                    .dataSource(dataSource)
                    .loadDefaultConfigurationFiles()
                    .skipDefaultCallbacks(!defaultCallbacks)
                    .cleanDisabled(false)
                    .load();
            if (clean){
                flyway.clean();
            }
            flyway.migrate();
        }
    }
}
