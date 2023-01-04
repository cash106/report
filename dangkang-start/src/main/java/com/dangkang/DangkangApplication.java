package com.dangkang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author anzj
 * @date 2022/12/30 11:32
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableConfigurationProperties
public class DangkangApplication {

    public static void main(String[] args) {

        System.setProperty("profile","dev");
        SpringApplication.run(DangkangApplication.class, args);

    }
}
