package com.nf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSource {
	
    public static JdbcTemplate busin;
	
    public static JdbcTemplate report;
    
	
	@Autowired(required = true)
	public void setFMDCDataSource(@Qualifier("businJdbcTemplate") JdbcTemplate jdbcTemplate) {
		DataSource.busin = jdbcTemplate;
	}

	@Autowired(required = true)
	public void setWindDataSource(@Qualifier("reportJdbcTemplate") JdbcTemplate jdbcTemplate) {
		DataSource.report = jdbcTemplate;
	}

}
