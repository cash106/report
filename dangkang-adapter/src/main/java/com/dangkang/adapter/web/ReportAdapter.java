package com.dangkang.adapter.web;

import com.dangkang.app.reportcontext.sh.service.EodService;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.ibatis.OpenedAccountDOIbatis;
import com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.mapper.ibatis.OpenedAccountMapperIbatis;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    EodService eodService ;

    @Autowired
    OpenedAccountMapperIbatis mapperIbatis ;
/*
    @GetMapping("/do")
    @ResponseBody
    public String doGenerateReport(){
        logger.info("hahaha");
        Boolean aBoolean = eodService.execute();
        logger.info("EodService响应参数 response = [{}]",aBoolean);
        return aBoolean.toString();
    }*/

    @GetMapping("/do")
    @ResponseBody
    public List<OpenedAccountDOIbatis> doIt () {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DB_DATE_FORMAT) ;
        String date = "2023-02-26" ;
        return mapperIbatis.findAllByDate(date, new RowBounds(1, 2)) ;
    }
}
