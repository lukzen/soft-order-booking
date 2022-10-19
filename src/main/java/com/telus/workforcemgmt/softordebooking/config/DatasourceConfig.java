package com.telus.workforcemgmt.softordebooking.config;

import com.telus.workforcemgmt.async.pubsub.EnvironmentConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DatasourceConfig {

    @Bean("asyncDataSource")
    public DataSource asyncDataSource(@Qualifier("appConfigEnv") Map<String, String> config) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(config.get(EnvironmentConfig.ASYNC_DB_URL.name()));
        dataSourceBuilder.username(config.get(EnvironmentConfig.ASYNC_DB_USERNAME.name()));
        dataSourceBuilder.password(config.get(EnvironmentConfig.ASYNC_DB_PASSWORD.name()));
        return dataSourceBuilder.build();
    }
}
