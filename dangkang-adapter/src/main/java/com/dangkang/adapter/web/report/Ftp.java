package com.dangkang.adapter.web.report;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

/**
 * @author Orkesh
 * @time 2023/3/6 10:37
 */
@Component
public class Ftp implements com.dangkang.app.reportcontext.util.Ftp {
    private static final Logger LOG = LoggerFactory.getLogger(Ftp.class);

    @Override
    public FTPClient getFTPClient(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword) {
        FTPClient ftp = null;
        try {
            ftp = new FTPClient();
            // 连接FPT服务器,设置IP及端口
            ftp.connect(ftpHost, ftpPort);
            // 设置用户名和密码
            ftp.login(ftpUserName, ftpPassword);
            // 设置连接超时时间,5000毫秒
            ftp.setConnectTimeout(50000);
            // 设置中文编码集，防止中文乱码
            ftp.setControlEncoding("UTF-8");
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                LOG.info("未连接到FTP，用户名或密码错误");
                ftp.disconnect();
            } else {
                LOG.info("FTP连接成功");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            LOG.info("FTP的IP地址可能错误，请正确配置");
        } catch (IOException e) {
            e.printStackTrace();
            LOG.info("FTP的端口错误,请正确配置");
        }
        return ftp;
    }

    @Override
    public boolean closeFTP(FTPClient ftp) {
        try {
            ftp.logout();
            return true ;
        } catch (Exception e) {
            LOG.error("FTP关闭失败") ;
        }finally{
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    LOG.error("FTP关闭失败") ;
                }
            }
        }
        return false ;
    }

    @Override
    public boolean uploadFile(FTPClient ftp, String filePath, String ftpPath) {
        boolean flag = false;
        File file = new File(filePath);
        try(InputStream in =new FileInputStream(file);) {
            // 设置PassiveMode传输
            ftp.enterLocalPassiveMode();
            //设置二进制传输，使用BINARY_FILE_TYPE，ASC容易造成文件损坏
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //判断FPT目标文件夹时候存在不存在则创建
            if(!ftp.changeWorkingDirectory(ftpPath)){
                ftp.makeDirectory(ftpPath);
            }
            //跳转目标目录
            ftp.changeWorkingDirectory(ftpPath);

            //上传文件
            String tempName = ftpPath+File.separator+file.getName();
            flag = ftp.storeFile(new String (tempName.getBytes("UTF-8"),"ISO-8859-1"),in);
            if(flag){
                LOG.info("上传成功");
            }else{
                LOG.error("上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("上传失败");
        }
        return flag;
    }

}
