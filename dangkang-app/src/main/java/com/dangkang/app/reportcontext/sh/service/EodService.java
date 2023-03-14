package com.dangkang.app.reportcontext.sh.service;
import com.dangkang.app.annotation.ApplicationService;
import com.dangkang.app.exception.ExceptionResolver;
import com.dangkang.app.reportcontext.util.Compress;
import com.dangkang.app.reportcontext.util.Digest;
import com.dangkang.client.dto.response.Response;
import com.dangkang.domain.reportcontext.ability.GenerateReportService;
import com.dangkang.domain.reportcontext.exception.ReportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;
/**
 * @author Orkesh
 * @date 2023/2/21 14:31
 * 描述 :         相当于ApplicationService。发布服务来给调用方统一使用
 */
@Service
public class EodService {

   @Autowired
   private  SHGenerateReportService shGenerateReportService;

   @Autowired
   private Compress compress ;

   @Autowired
   private Digest digest ;

    private static final Logger LOG = LoggerFactory.getLogger(EodService.class) ;
    private   ExecutorService executor =Executors.newFixedThreadPool(10);

    public static final long GENERATE_REPORT_TIMEOUT_MINUTE=30;


    public void execute() {
        int reportCount=this.shGenerateReportService.getTotalReport();
        CountDownLatch countDownLatch = new CountDownLatch(reportCount) ;
        for(String reportName:this.shGenerateReportService.getServiceMap().keySet()){
            executor.submit(new ReportTask(countDownLatch, reportName) ) ;
        }
        try {
            countDownLatch.await(GENERATE_REPORT_TIMEOUT_MINUTE,TimeUnit.MINUTES) ;
        } catch (InterruptedException e) {
            throw new ReportException().setPromptMessage("系统异常").
                                                             setDetailMessage("线程中断,等待所有报表完成超时时间为%s分钟",String.valueOf(GENERATE_REPORT_TIMEOUT_MINUTE)).
                                                             setCause(e);
        }
    }

    private class ReportTask implements Runnable {
        CountDownLatch countDownLatch ;
        private String reportName ;
        public ReportTask(CountDownLatch countDownLatch, String reportName) {
            this.countDownLatch = countDownLatch ;
            this.reportName = reportName ;
        }
        @Override
        public void run() {
            try{
                GenerateReportService gs=EodService.this.shGenerateReportService.getService(reportName);
                String reportFileName="";
                if(gs!=null) reportFileName =gs .execute() ;
                /* 加密压缩和MD5摘要生成 */
                if(!reportFileName.equals("")) {
                    String compressedFileName = compress.compress(reportFileName);
                    LOG.info("对[{}]进行压缩已成功。所生成的压缩文件名为[{}]", reportFileName, compressedFileName) ;
                    String MD5Str = digest.execute(reportFileName);
                    LOG.info("对[{}]进行MD5摘要生成已成功。所生成的压缩文件名为[{}]", reportFileName, MD5Str) ;
                }
                LOG.info("报表[{}]成功生成报表文件为[{}]", reportName,reportFileName) ;
            }catch(Exception e) {
                throw new ReportException().setPromptMessage("报表%s生成失败",reportName).setCause(e);
            }finally {
                this.countDownLatch.countDown() ;
            }
        }

        /**
         * 发布的Eod的服务
         */
       @ExceptionResolver
       @ApplicationService(ServiceCode = "E001",ServiceName = "生成上清所报表服务")
        public Response<String> eodService(){
           execute();
           return new Response<String>();
        }
    }

}
