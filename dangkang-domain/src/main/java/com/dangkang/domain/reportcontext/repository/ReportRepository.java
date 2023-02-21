package com.dangkang.domain.reportcontext.repository;

import com.dangkang.domain.reportcontext.model.type.Node;

import java.util.Date;
import java.util.List;

/**
 * @author Orkesh
 * @date 2023/2/21 13:43
 * 描述 :         报表数据仓的共同接口定义
 */
public interface ReportRepository {

    public List<Node> getNodes(Date date, int index, int size) ;

    public Integer getTotalRecords(Date date, String reportFileName) ;

    public String saveAll (List<Node> nodes) ;

    public default int computePageCount (Integer totalRecords, Integer pageSize) {
        Double pages = Math.ceil((double) totalRecords / pageSize) ;
        return pages.intValue() ;
    }
}
