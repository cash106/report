package com.dangkang.app.reportcontext.serviceimpl;

import com.dangkang.app.reportcontext.openedaccounts.serviceimpl.OpenedAccountGenerateReportFileService;
import com.dangkang.domain.reportcontext.ability.BusinessDateService;
import com.dangkang.domain.reportcontext.ability.GenerateReportFileService;
import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractGenerateReportFileService implements GenerateReportFileService {
    private static final Logger LOG = LoggerFactory.getLogger(OpenedAccountGenerateReportFileService.class);
    @Autowired
    ReportConfig reportConfig;
    @Autowired
    BusinessDateService businessDateService;

    protected String generateReportFile(ReportRepository reportRepository) {
        String reportFileName = "";
        Integer totalRecords = reportRepository.getTotalRecordCount(businessDateService.getBusinessDate());
        Integer pageCount = reportRepository.computePageCount(totalRecords, reportConfig.getPageSize());
        for (int i = 0; i < pageCount; ++i) {
            int pageIndex = i + 1;
            PageResponse<Node> page = reportRepository.getPage(businessDateService.getBusinessDate(), pageIndex, reportConfig.getPageSize());
            reportFileName = reportRepository.saveToReportFile(page);
            LOG.info("第{}页数据已被写入报表文件{}", pageIndex, reportFileName);
        }
        return reportFileName;
    }
}
