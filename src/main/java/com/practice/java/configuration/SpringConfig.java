package com.practice.java.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name="test")
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return  dataSource;
    }

    @Bean(name="test1")
    public DataSource dataSourceTest()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return  dataSource;
    }

    @Bean(name="Jdbctest")
    public JdbcTemplate jdbcTemplate(@Qualifier("test") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="Jdbctest1")
    public JdbcTemplate jdbcTemplateTest(@Qualifier("test1") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }



}
