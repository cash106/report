package com.dangkang.app.reportcontext.sh.service;

import com.dangkang.app.reportcontext.sh.openedaccounts.serviceimpl.OpenedAccountGenerateReportService;
import com.dangkang.domain.reportcontext.ability.GenerateReportService;
import com.dangkang.domain.reportcontext.exception.ReportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SHGenerateReportService {

    public static final String openedAccountsReport = "openedAccounts" ;

    @Autowired
    OpenedAccountGenerateReportService openedAccountGenerateReportFileService ;

    private Map<String, GenerateReportService> generateReportServiceMap =new HashMap<String, GenerateReportService>();
    {
        generateReportServiceMap.put(openedAccountsReport, openedAccountGenerateReportFileService);
    }

    public String generateReportFile(String reportName) {
        GenerateReportService service= generateReportServiceMap.get(reportName);
        if(service!=null)return service.execute();
        throw new ReportException().setPromptMessage("报表%s没有定义",reportName);
    }

    public Map<String, GenerateReportService> getServiceMap(){
        return this.generateReportServiceMap;
    }

    public GenerateReportService getService(String reportName){
        return generateReportServiceMap.get(reportName);
    }

    public int getTotalReport(){
        return this.generateReportServiceMap.size();
    }

}
