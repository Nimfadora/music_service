package com.vasylieva.music_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * The data source config that can be used in integration tests.
 */
@Configuration
@Profile("test")
public class EmbeddedDataSourceConfig {

}
