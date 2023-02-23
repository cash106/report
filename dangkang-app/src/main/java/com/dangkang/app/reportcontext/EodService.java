package com.dangkang.app.reportcontext;

import com.dangkang.app.reportcontext.openedaccounts.serviceimpl.OpenedAccountGenerateReportFileService;
import com.dangkang.domain.exception.ApplicationException;
import com.dangkang.domain.reportcontext.ability.GenerateReportFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Orkesh
 * @date 2023/2/21 14:31
 * 描述 :         相当于ApplicationService。发布服务来给调用方统一使用
 */
@Service
public class EodService {

    private static final Logger LOG = LoggerFactory.getLogger(EodService.class) ;
    private static final ExecutorService executor = Executors.newFixedThreadPool(7) ;


    /*public Boolean execute() {
        CountDownLatch countDownLatch = new CountDownLatch(1) ;
        boolean returnResult = true ;
        ArrayList<Callable> callables = new ArrayList<>() ;
        callables.add(new ReportTask(countDownLatch, openedAccountsReport) ) ;
        ArrayList<Future> futures = new ArrayList<>() ;
        for(int i = 0 ; i < callables.size() ; ++i) {
            Future future = executor.submit(callables.get(i)) ;
            futures.add(future) ;
        }
        try {
            countDownLatch.await() ;
            for(int i = 0 ; i < futures.size() ; ++ i) {
                Future<Boolean> future = futures.get(i) ;
                Boolean result = future.get(60l, TimeUnit.SECONDS) ;
                if(result == false)
                    returnResult = false ;
            }
        } catch (InterruptedException e) {
            returnResult = false ;
            LOG.error("在处理报表生成过程中子任务被中断, 错误信息为:{}" + e.getMessage());
            return returnResult ;
        } catch (ExecutionException e) {
            returnResult = false ;
            LOG.error("在处理报表生成过程中捕获了异常:{}" + e.getMessage());
            return returnResult ;
        } catch (TimeoutException e) {
            returnResult = false ;
            LOG.error("在处理上清所报表生成过程中任务结果获取超时:{}" + e.getMessage() );
            return returnResult ;
        }
        return returnResult ;
    }

    private class ReportTask implements Callable<Boolean> {
        CountDownLatch countDownLatch ;
        private String reportName ;
        public ReportTask(CountDownLatch countDownLatch, String reportName) {
            this.countDownLatch = countDownLatch ;
            this.reportName = reportName ;
        }
        @Override
        public Boolean call() throws Exception {
            try{
                String reportFileName = this.generateReportFile(reportName) ;
            }catch(ApplicationException e) {
                LOG.error("报表文件{}生成及加密压缩流程也难怪以失败告终", reportName) ;
                return false ;
            }finally {
                this.countDownLatch.countDown() ;
            }
            return true ;
        }
*/

   // }
}
