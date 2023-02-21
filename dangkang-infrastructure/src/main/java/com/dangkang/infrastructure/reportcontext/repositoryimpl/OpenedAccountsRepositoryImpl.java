package com.dangkang.infrastructure.reportcontext.repositoryimpl;

import com.dangkang.domain.reportcontext.model.Page;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 13:50
 * 描述 :         开户数据报表数据仓（实现）
 */
@Component
public class OpenedAccountsRepositoryImpl implements ReportRepository {

    public static final String REPORT_FILE_NAME = "BankAccountOpen.txt" ; //清算所开户数据文件具体文件名 + 扩展名

    @Autowired
    ReportFile reportFile ;

    @Override
    public Page getPage(Date date, int index, int size) {
        return null;
    }

    @Override
    public Integer getTotalRecords(Date date) {
       return 0;//TODO
    }

    @Override
    public String saveToReportFile(Page page) {
        reportFile.save(page, REPORT_FILE_NAME) ;
        return REPORT_FILE_NAME ;
    }
}
