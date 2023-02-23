package com.dangkang.domain.reportcontext.repository;

import com.dangkang.domain.reportcontext.model.Node;
import com.dangkang.domain.reportcontext.model.Page;

import java.util.Date;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:43
 * 描述 :         报表数据仓的共同接口定义
 */
public interface ReportRepository {

    public static final String DB_DATE_FORMAT = "yyyy-MM-dd" ;
    public static final String SYSTEM_DATE_FORMAT = "yyyyMMdd" ;

    public Page getPage(Date date, int index, int size) ;

    public Integer getTotalRecords(Date date) ;

    public String saveToReportFile(Page page) ;



    public default int computePageCount (Integer totalRecords, Integer pageSize) {
       return new Double(Math.ceil((double) totalRecords / pageSize)).intValue() ;
    }

    public default Page pageOf(int pageIndex, long totalElementsCount, int totalPagesCount, List<Node> nodes) {
        Page page = new Page();
        page.setCurrentPage(pageIndex) ;
        page.setNodeList(nodes) ;
        page.setTotalPageCount(totalPagesCount);
        page.setTotalElementCount(totalElementsCount);
        return page ;
    }
}
