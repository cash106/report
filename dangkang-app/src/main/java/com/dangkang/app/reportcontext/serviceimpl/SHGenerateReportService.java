package com.dangkang.app.reportcontext.serviceimpl;

import com.dangkang.app.reportcontext.openedaccounts.serviceimpl.OpenedAccountGenerateReportFileService;
import com.dangkang.domain.reportcontext.ability.GenerateReportFileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class SHGenerateReportService {

    public static final String openedAccountsReport = "openedAccounts" ;

    @Autowired
    OpenedAccountGenerateReportFileService openedAccountGenerateReportFileService ;

    private Map<String, GenerateReportFileService> generateReportFileServiceMap =new HashMap<String, GenerateReportFileService>();

    {
        generateReportFileServiceMap.put(openedAccountsReport, openedAccountGenerateReportFileService);
    }

    public String generateReportFile(String reportName) {
        GenerateReportFileService service=generateReportFileServiceMap.get(reportName);
        if(service!=null)return service.generateReportFile();
        return "";
    }

}
