package com.dangkang.app.reportcontext.util;

import org.apache.commons.net.ftp.FTPClient;

/**
 * @author Orkesh
 * @time 2023/3/6 10:44
 */
public interface Ftp {

    /**
     * 获取FTPClient对象
     * @param ftpHost 服务器IP
     * @param ftpPort 服务器端口号
     * @param ftpUserName 用户名
     * @param ftpPassword 密码
     * @return FTPClient
     */
    public FTPClient getFTPClient(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword) ;

    /**
     * 关闭FTP方法
     * @param ftp
     * @return
     */
    public boolean closeFTP(FTPClient ftp) ;

    /**
     * FTP文件上传
     * @param ftp
     * @param filePath
     * @param ftpPath
     * @return
     */
    public boolean uploadFile(FTPClient ftp,String filePath,String ftpPath) ;
}
