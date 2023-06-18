package com.berkanaslan.springnativemultipledatasource.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class MySQLDataSourceConfiguration {

    @Primary
    @Bean(name="mysqlDataSource")
    @ConfigurationProperties("mysql.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

}
