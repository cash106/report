package com.dangkang.app.reportcontext.util;

import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Digest {
    private static final Logger LOG = LoggerFactory.getLogger(Digest.class);

    @Autowired
    ReportConfig reportConfig;

    public String md5Summary(ReportRepository repository) {
        File file = new File(reportConfig.getRootPath(), repository.reportNameWithExtension());
        String md5Sum = null ;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5") ;
            md5.update(Files.readAllBytes(file.toPath()));
            md5Sum = DatatypeConverter.printHexBinary(md5.digest()).toUpperCase() ;
        } catch (NoSuchAlgorithmException e) {
            LOG.error("在针对{}进行MD5摘要生成工作时发生了“无此算法异常:{}", file.getName(), e.getMessage());
        } catch (IOException e) {
            LOG.error("在针对{}进行MD5摘要生成工作时发生了IO异常:{}", file.getName(), e.getMessage());
        }
        return md5Sum ;
    }


}
