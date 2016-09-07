package com.retailstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc //<mvc:annotation-driven />
@Configuration
@ComponentScan({ "com.retailstore.controller" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {


}
