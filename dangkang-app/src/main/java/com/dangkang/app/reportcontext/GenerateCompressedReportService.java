package com.dangkang.app.reportcontext;

import com.dangkang.domain.reportcontext.ability.BusinessDateService;
import com.dangkang.domain.reportcontext.model.Page;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import com.dangkang.infrastructure.reportcontext.repositoryimpl.OpenedAccountsRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Orkesh
 * @date 2023/2/21 14:11
 * 描述 :         基于当日业务数据生成被加密压缩的数据报表服务
 */
@Component
public class GenerateCompressedReportService {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateCompressedReportService.class) ;

    @Autowired
    OpenedAccountsRepositoryImpl openedAccountsRepository ;

    @Autowired
    ReportConfig reportConfig ;

    @Autowired
    BusinessDateService businessDateService ;

    public String generateOpenedAccountsReport() {return generateReportFile(openedAccountsRepository) ; }

    private String generateReportFile (ReportRepository reportRepository) {
        String reportFileName = "" ;
        Integer totalRecords = reportRepository.getTotalRecords(businessDateService.businessDate()) ;
        Integer pageCount = reportRepository.computePageCount(totalRecords, reportConfig.getPageSize()) ;
        for(int i = 0 ; i < pageCount ; ++ i) {
            int pageIndex = i + 1 ;
            Page page = reportRepository.getPage(businessDateService.businessDate(), pageIndex, reportConfig.getPageSize()) ;
            reportFileName = reportRepository.saveToReportFile(page) ;
            LOG.info("第{}页数据已被写入报表文件{}", pageIndex, reportFileName);
        }
        return reportFileName ;
    }
}