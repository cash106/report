package com.dangkang.infrastructure.reportcontext.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Orkesh
 * @time 2023/3/6 10:39
 */
@Component
@PropertySource(value = "classpath:ftp.properties")
@ConfigurationProperties(prefix = "shftp")
public class FTPConfig {

    private String ftpHost ;
    private int ftpPort ;
    private String ftpUserName ;
    private String ftpPassword ;

    private String ftpPath ;

    public String getFtpHost() {
        return ftpHost;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath;
    }
}
