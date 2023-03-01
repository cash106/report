package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl;

import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.OpenedAccountConverter;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.OpenedAccountDO;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper.OpenedAccountMapper;
import com.dangkang.infrastructure.reportcontext.util.ReportFile;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:50
 * 描述 :         开户数据报表数据仓（实现）
 */
@Component
public class OpenedAccountsRepositoryImpl implements ReportRepository{

    public static final String REPORT_FILE_NAME = "BankAccountOpen.txt" ; //清算所开户数据文件具体文件名 + 扩展名

    public static final String DB_DATE_FORMAT = "yyyy-MM-dd" ;
    public static final String SYSTEM_DATE_FORMAT = "yyyyMMdd" ;

    @Autowired
    ReportFile reportFile ;

    @Autowired
    OpenedAccountMapper openedAccountMapper ;

    @Override
    public PageResponse<Node>  getPage (Date date, int index, int size) {
        PageHelper.startPage(index, size) ;
        List<OpenedAccountDO> openedAccountDOIbatis = openedAccountMapper.pageFind(new SimpleDateFormat(DB_DATE_FORMAT).format(date)) ;
        PageResponse<Node> page = this.pageOf(index, openedAccountDOIbatis.size(), OpenedAccountConverter.convert2NodeList(openedAccountDOIbatis)) ;
        return page ;
    }

    @Override
    public Integer getTotalRecordCount(Date date) {
        return openedAccountMapper.getRecordTotalCount(new SimpleDateFormat(DB_DATE_FORMAT).format(date)) ;
    }

    @Override
    public String batchSaveToReportFile(PageResponse<Node> page) {
        reportFile.save(page, REPORT_FILE_NAME) ;
        return REPORT_FILE_NAME ;
    }
}
