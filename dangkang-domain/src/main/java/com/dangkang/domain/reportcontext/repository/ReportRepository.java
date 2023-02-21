package com.dangkang.domain.reportcontext.repository;

import com.dangkang.domain.reportcontext.model.Page;

import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 13:43
 * 描述 :         报表数据仓的共同接口定义
 */
public interface ReportRepository {

    public Page getPage(Date date, int index, int size) ;

    public Integer getTotalRecords(Date date) ;

    public String saveToReportFile(Page page) ;



    public default int computePageCount (Integer totalRecords, Integer pageSize) {
       return new Double(Math.ceil((double) totalRecords / pageSize)).intValue() ;
    }
}
