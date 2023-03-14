package com.dangkang.app.reportcontext.util;

import com.dangkang.domain.reportcontext.ability.BusinessDateService;
import com.dangkang.domain.reportcontext.exception.ReportException;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class Compress {

    private static final Logger LOG = LoggerFactory.getLogger(Compress.class);
    @Autowired
    ReportConfig reportConfig;
    @Autowired
    BusinessDateService businessDateService;

    public String compress(String  reportFileName) {
        File reportFile = new File(reportConfig.getRootPath(),reportFileName);
        String zipReportFileName = reportFile.getName().substring(0, reportFile.getName().lastIndexOf('.')).concat(".zip");
        try (FileOutputStream fos = new FileOutputStream(reportConfig.getRootPath() + zipReportFileName);ZipOutputStream zos = new ZipOutputStream(fos)){
            zos.putNextEntry(new ZipEntry(reportFile.getName()));
            byte []  buf=new byte[2048];
            FileInputStream ios=new FileInputStream(reportFile);
            int len=-1;
            while((len= ios.read(buf))!=-1){
                zos.write(buf, 0, len);
            }
            zos.closeEntry();
            LOG.info("报表文件{}压缩成zip文件{}",reportFileName,zipReportFileName);
        } catch (FileNotFoundException ex) {
            throw new ReportException().setPromptMessage("需压缩的文件 {} 不存在",reportFileName);
        } catch (IOException ex) {
            throw new ReportException().setCause(ex).setPromptMessage("压缩的文件 {} 失败",reportFileName);
        }
        return zipReportFileName ;
    }
}
