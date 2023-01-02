package com.dangkang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author anzj
 * @date 2022/12/30 11:32
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableConfigurationProperties
public class DangkangApplication {

    public static void main(String[] args) {
        System.setProperty("profile","dev");
        ApplicationContext applicationContext = SpringApplication.run(DangkangApplication.class, args);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name :names){
            if(name.contains("applicationServiceController"))
            System.out.println(name);
        }
    }
}
