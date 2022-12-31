package com.dangkang.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author anzj
 * @date 2022/12/30 11:32
 */
@SpringBootApplication
@EnableConfigurationProperties
public class DangkangApplication {
    public static void main(String[] args) {
        SpringApplication.run(DangkangApplication.class);
    }
}
