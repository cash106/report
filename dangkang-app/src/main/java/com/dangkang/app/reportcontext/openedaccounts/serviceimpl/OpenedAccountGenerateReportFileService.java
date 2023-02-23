package com.dangkang.app.reportcontext.openedaccounts.serviceimpl;

import com.dangkang.app.reportcontext.serviceimpl.AbstractGenerateReportFileService;

import com.dangkang.infrastructure.reportcontext.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Orkesh
 * @date 2023/2/21 14:11
 * 描述 :         基于当日业务数据生成被加密压缩的数据报表服务
 */
@Component
public class OpenedAccountGenerateReportFileService extends AbstractGenerateReportFileService {
    @Autowired
    public OpenedAccountsRepositoryImpl openedAccountRepository;

    public String generateReportFile() {
        return generateReportFile(openedAccountRepository) ;
    }

}
