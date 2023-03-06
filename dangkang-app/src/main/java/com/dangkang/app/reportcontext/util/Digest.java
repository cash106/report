package com.dangkang.app.reportcontext.util;

import com.dangkang.domain.reportcontext.exception.ReportException;

import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.*;
import java.math.BigInteger;

import java.security.MessageDigest;

@Component
public class Digest {
    private static final Logger LOG = LoggerFactory.getLogger(Digest.class);

    @Autowired
    ReportConfig reportConfig;

    public String execute(String reportFileName) {
        File reportFile = new File(reportConfig.getRootPath(),reportFileName);
        File md5File=new File(reportConfig.getRootPath(),this.getMd5FileName(reportFileName));
        String md5Str ="";
        try (FileInputStream fis = new FileInputStream(reportFile); FileWriter md5Writer=new FileWriter(md5File)){
            MessageDigest md = MessageDigest.getInstance("MD5");
            int len = 0;
            byte[] buffer = new byte[8192];
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            byte[] b = md.digest();
            md5Str = new BigInteger(1, b).toString(16);
            md5Writer.write(md5Str);
            LOG.info("报表文件{}成功生成MD5：{}",reportFileName,md5Str);
        } catch (Exception e) {
            throw new ReportException().setCause(e).setPromptMessage("报表文件{}成功生成MD5失败",reportFileName);
        }
        return md5Str;
    }

    private String getMd5FileName(String reportFileName){
        String md5FileName=reportFileName;
        int dotIndex=reportFileName.lastIndexOf(".");
        if(dotIndex!=-1){
            md5FileName=reportFileName.substring(0,dotIndex);
        }
        md5FileName=md5FileName.concat(".md5");
        return md5FileName;
    }
}
