package com.dangkang.infrastructure.reportcontext.repositoryimpl;

import com.dangkang.domain.reportcontext.model.type.Node;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.config.ReportConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:50
 * 描述 :         开户数据报表数据仓（实现）
 */
public class OpenedAccountsRepositoryImpl implements ReportRepository {

    public static final String REPORT_FILE_NAME = "BankAccountOpen.txt" ; //清算所开户数据文件具体文件名 + 扩展名

    @Autowired
    ReportFile reportFile ;

    @Autowired
    ReportConfig reportConfig ;

    @Override
    public List<Node> getNodes(Date date, int index, int size) {
        return null;
    }

    @Override
    public Integer getTotalRecords(Date date, String reportFileName) {
        reportFileName = REPORT_FILE_NAME ;
        return null ;
    }

    @Override
    public String saveAll(List<Node> nodes) {
        reportFile.save(nodes, REPORT_FILE_NAME) ;
        return REPORT_FILE_NAME ;
    }
}
