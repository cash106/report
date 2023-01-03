package com.dangkang.infrastructure.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author anzj
 * @date 2022/12/30 11:10
 */
@Component
@PropertySource(value = "classpath:config/application.properties")
public class ApplicationConfig {

    private String systemCode;
    private String systemDescription;

    public String getSystemDescription() {
        return systemDescription;
    }

    public void setSystemDescription(String systemDescription) {
        this.systemDescription = systemDescription;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
