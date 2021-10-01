package com.cousre3.data.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("plant.datasource")
    public DataSource getDataSource() {
        DataSourceBuilder<?> dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://localhost:3306/plant");
        return dsb.build();
    }
}
