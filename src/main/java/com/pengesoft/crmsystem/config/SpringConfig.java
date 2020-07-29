package com.pengesoft.crmsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xlang
 * @date 2019-11-25 20:54
 */
@Configuration
@ImportResource(locations = {"classpath:spring.xml"})
@PropertySource(value = {"classpath:application.properties"}, encoding = "UTF-8")
public class SpringConfig {

}
