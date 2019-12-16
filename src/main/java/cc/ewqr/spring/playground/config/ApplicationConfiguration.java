package cc.ewqr.spring.playground.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cc.ewqr.spring.playground.model", "cc.ewqr.spring.playground.service"})
public class ApplicationConfiguration {
}
