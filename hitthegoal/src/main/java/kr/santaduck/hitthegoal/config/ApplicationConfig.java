package kr.santaduck.hitthegoal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.santaduck.hitthegoal.dao", "kr.santaduck.hitthegoal.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
