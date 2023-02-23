package com.dangkang.infrastructure.reportcontext.repositoryimpl;

import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.converter.OpenedAccountConverter;
import com.dangkang.infrastructure.reportcontext.repositoryimpl.dataobject.OpenedAccountDO;
import com.dangkang.infrastructure.reportcontext.repositoryimpl.mapper.OpenedAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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

    @Autowired
    OpenedAccountMapper openedAccountMapper ;

    @Override
    public com.dangkang.domain.reportcontext.model.Page getPage(Date date, int index, int size) {
        Pageable pageable = PageRequest.of(index - 1, size, Direction.DESC, "id") ;
        Page<OpenedAccountDO> openedAccountDOPage = openedAccountMapper.findAllByDate(
                this.generateConditionerDate(date)[0],
                this.generateConditionerDate(date)[1],
                pageable) ;
        com.dangkang.domain.reportcontext.model.Page page = this.pageOf(
                index,
                openedAccountDOPage.getTotalElements(),
                openedAccountDOPage.getTotalPages(),
                OpenedAccountConverter.convertToNodeList(openedAccountDOPage.getContent())
        ) ;
        return page;
    }

    @Override
    public Integer getTotalRecords(Date date) {
        return openedAccountMapper.getTotalElementCount(this.generateConditionerDate(date)[0], this.generateConditionerDate(date)[1]) ;
    }

    @Override
    public String saveToReportFile(com.dangkang.domain.reportcontext.model.Page page) {
        reportFile.save(page, REPORT_FILE_NAME) ;
        return REPORT_FILE_NAME ;
    }
}
