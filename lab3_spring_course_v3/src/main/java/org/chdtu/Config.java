package org.chdtu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.chdtu")
@PropertySource("classpath:myApp.properties")
@EnableAspectJAutoProxy
public class Config {
}