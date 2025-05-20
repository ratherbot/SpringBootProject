package com.freshmarket.fruitmarket.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("prod")
public class ProdOnlyConfig {

    @Bean
    public DataSource dataSource() {
        var ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://prodhost:5432/proddb");
        ds.setUsername("produser");
        ds.setPassword("prodpass");
        return ds;
    }

    @Bean
    public String demoBeanProd() {
        return "Prod PB";
    }
}