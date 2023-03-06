package com.dangkang.app.reportcontext.util;

import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.FtpConfig;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class Transfer {
    private static final Logger LOG = LoggerFactory.getLogger(Transfer.class);

    @Autowired
    private FtpConfig ftpConfig ;
    @Autowired
    private Ftp ftp ;
    @Autowired
    private ReportConfig reportConfig ;

    public String transfer (ReportRepository repository) {
        /* 获取ftpClient */
        FTPClient ftpClient = ftp.getFTPClient(ftpConfig.getFtpHost(), ftpConfig.getFtpPort(), ftpConfig.getFtpUserName(), ftpConfig.getFtpPassword()) ;
        /* 将report传输到清算所前置机指定目录 */
        ftp.uploadFile(ftpClient, new File(reportConfig.getRootPath(), repository.zipNameWithExtension()).getAbsolutePath(), ftpConfig.getFtpPath()) ;
        /* 关闭ftp连接 */
        ftp.closeFTP(ftpClient) ;
        LOG.info("文件{}的ftp传输至{}已完成", repository.zipNameWithExtension(), "上清所前置机");
        return repository.zipNameWithExtension() ;
    }

}
