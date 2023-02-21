package com.dangkang.infrastructure.reportcontext.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Orkesh
 * @date 2023/2/21 13:53
 * 描述 :         报表有关的Config
 */
@Component
@PropertySource(value = "classpath:report.properties")
@ConfigurationProperties(prefix = "report")
public class ReportConfig {

    private String rootPath ;

    private String charset ;

    private Integer pageSize ;

    private String shanghaiToken ;

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getShanghaiToken() {
        return shanghaiToken;
    }

    public void setShanghaiToken(String shanghaiToken) {
        this.shanghaiToken = shanghaiToken;
    }

    public String decrypthShToken () {
        //TODO 报表加密压缩的密码
        return "" ;
    }

    public String ecryptShToken() {
        //TODO 报表加密压缩的密码
        return "" ;
    }
}
