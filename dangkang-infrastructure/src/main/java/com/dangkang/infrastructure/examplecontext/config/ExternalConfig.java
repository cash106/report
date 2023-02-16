package com.dangkang.infrastructure.examplecontext.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @date 2022/12/30 11:27
 */
@Component
@PropertySource("classpath:config/external-${profile}.properties")
@ConfigurationProperties(prefix = "external.system")
    public class ExternalConfig {

    private String url;

    private String callServiceName;

    private String queryServiceName;

    private Integer readTimeoutForCallService;

    private Integer connectionTimeoutForCallService;

    private Integer readTimeoutForQueryService;

    private Integer connectionTimeoutForQueryService;


    public Integer getReadTimeoutForQueryService() {
        return readTimeoutForQueryService;
    }

    public void setReadTimeoutForQueryService(Integer readTimeoutForQueryService) {
        this.readTimeoutForQueryService = readTimeoutForQueryService;
    }

    public Integer getConnectionTimeoutForQueryService() {
        return connectionTimeoutForQueryService;
    }

    public void setConnectionTimeoutForQueryService(Integer connectionTimeoutForQueryService) {
        this.connectionTimeoutForQueryService = connectionTimeoutForQueryService;
    }

    public String getQueryServiceName() {
        return queryServiceName;
    }

    public void setQueryServiceName(String queryServiceName) {
        this.queryServiceName = queryServiceName;
    }

    public Integer getReadTimeoutForCallService() {
        return readTimeoutForCallService;
    }

    public void setReadTimeoutForCallService(Integer readTimeoutForCallService) {
        this.readTimeoutForCallService = readTimeoutForCallService;
    }

    public Integer getConnectionTimeoutForCallService() {
        return connectionTimeoutForCallService;
    }

    public void setConnectionTimeoutForCallService(Integer connectionTimeoutForCallService) {
        this.connectionTimeoutForCallService = connectionTimeoutForCallService;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCallServiceName() {
        return callServiceName;
    }

    public void setCallServiceName(String callServiceName) {
        this.callServiceName = callServiceName;
    }
}
