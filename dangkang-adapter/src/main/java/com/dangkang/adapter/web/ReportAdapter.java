package com.dangkang.adapter.web;

import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.repository.ReportRepository;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.ibatis.OpenedAccountDOIbatis;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper.ibatis.OpenedAccountMapperIbatis;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl.DB_DATE_FORMAT;

/**
 * @author Orkesh
 * @date 2023/2/23 13:37
 * 描述 :         report上下文的Adapter
 */

@RestController
public class ReportAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ReportAdapter.class);

//    @Autowired
//    EodService eodService ;

    @Autowired
    OpenedAccountMapperIbatis mapperIbatis ;

    @Autowired
    OpenedAccountsRepositoryImpl repository ;

}
