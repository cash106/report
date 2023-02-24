package com.dangkang.app.reportcontext.sh.openedaccounts.serviceimpl;

import com.dangkang.app.reportcontext.util.GenerateReport;
import com.dangkang.domain.reportcontext.ability.GenerateReportService;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Orkesh
 * @date 2023/2/21 14:11
 * 描述 :         基于当日业务数据生成被加密压缩的数据报表服务
 */
@Component
public class OpenedAccountGenerateReportService implements GenerateReportService {
    @Autowired
    public OpenedAccountsRepositoryImpl openedAccountRepository;

    @Autowired
    public GenerateReport generateReport;

    public String execute() {
        return generateReport.execute(openedAccountRepository);
    }
}
