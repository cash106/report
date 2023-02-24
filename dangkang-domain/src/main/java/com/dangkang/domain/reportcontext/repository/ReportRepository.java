package com.dangkang.domain.reportcontext.repository;

import com.dangkang.domain.reportcontext.dto.PageResponse;
import com.dangkang.domain.reportcontext.model.Node;


import java.util.Date;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:43
 * 描述 :         报表数据仓的共同接口定义
 */
public interface ReportRepository {



    public PageResponse<Node> getPage (Date date, int index, int size) ;

    public Integer getTotalRecordCount(Date date) ;

    public String batchSaveToReportFile(PageResponse<Node> page) ;


    public default int computePageCount (Integer totalCount, Integer pageSize) {
         return totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
    }

    public default PageResponse<Node> pageOf(int pageIndex, long totalRecordCount, List<Node> nodes) {
        return  new PageResponse<Node>().
                setTotalCount(totalRecordCount).
                setPageIndex(pageIndex).
                setData(nodes);
    }
}
