package com.dangkang.app.reportcontext.util;

import com.dangkang.domain.reportcontext.ability.BusinessDateService;
import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateReport {
    private static final Logger LOG = LoggerFactory.getLogger(GenerateReport.class);
    @Autowired
    ReportConfig reportConfig;
    @Autowired
    BusinessDateService businessDateService;

    public String execute(ReportRepository reportRepository) {
        String reportFileName = "";
        Integer totalRecords = reportRepository.getRecordTotalCount(businessDateService.getBusinessDate());
        Integer pageCount = reportRepository.computePageCount(totalRecords, reportConfig.getPageSize());
        for (int i = 0; i < pageCount; ++i) {
            int pageIndex = i + 1;
            PageResponse<Node> page = reportRepository.pageFind(businessDateService.getBusinessDate(), pageIndex, reportConfig.getPageSize());
            reportFileName = reportRepository.batchSaveToReportFile(page);
            LOG.info("第{}页数据已被写入报表文件{}", pageIndex, reportFileName);
        }
        return reportFileName;
    }
}
