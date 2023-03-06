package com.dangkang.app.reportcontext.util;

import com.dangkang.domain.reportcontext.ability.BusinessDateService;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Component
public class Compress {

    private static final Logger LOG = LoggerFactory.getLogger(Compress.class);
    @Autowired
    ReportConfig reportConfig;
    @Autowired
    BusinessDateService businessDateService;

    public String compress(ReportRepository repository) {
        String reportName = "" ;
        File file = new File(reportConfig.getRootPath(), repository.reportNameWithExtension());
        String zipFileName = file.getName().concat(".zip");
        try (FileOutputStream fos = new FileOutputStream(zipFileName);ZipOutputStream zos = new ZipOutputStream(fos)){
            zos.putNextEntry(new ZipEntry(file.getName()));

            byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            reportName = zipFileName ;
        } catch (FileNotFoundException ex) {
            LOG.error("需压缩的文件 {} 并不存在", repository.reportNameWithExtension());
        } catch (IOException ex) {
            LOG.error("在针对 {} 进行压缩时发生了 I/O error: " + ex);
        }
        return reportName ;
    }


}
