package com.dangkang.adapter.web.reportcontext;

import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.OpenedAccountsRepositoryImpl;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper.OpenedAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
    OpenedAccountMapper mapperIbatis ;

    @Autowired
    OpenedAccountsRepositoryImpl repository ;

}
