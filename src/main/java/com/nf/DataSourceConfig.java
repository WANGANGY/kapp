package com.nf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean(name = "businDataSource")
	@Qualifier("businDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.busin")
	public DataSource businDataSource() {
		return DataSourceBuilder.create().build();
	}
	
    @Bean(name = "businJdbcTemplate")  
    public JdbcTemplate businJdbcTemplate(  
            @Qualifier("businDataSource") DataSource dataSource) {  
        return new JdbcTemplate(dataSource);  
    }  

	@Bean(name = "reportDataSource")
	@Qualifier("reportDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.report")
	public DataSource reportDataSource() {
		return DataSourceBuilder.create().build();
	}

    @Bean(name = "reportJdbcTemplate")  
    public JdbcTemplate reportJdbcTemplate(  
            @Qualifier("reportDataSource") DataSource dataSource) {  
        return new JdbcTemplate(dataSource);  
    }  
    
}
