package com.dangkang.domain.reportcontext.model;

import java.util.List;

public class Page {

    private int size = 100;

    private int currentPage;

    private int totalPageCount ;

    private long totalElementCount ;

    private List<Node> nodeList;

    public Page(){}

    public int getSize() {
        return size;
    }

    public Page setSize(int size) {
        this.size = size;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public Page setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }


    public List<Node> getNodeList() {
        return nodeList;
    }

    public Page setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
        return this;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public long getTotalElementCount() {
        return totalElementCount;
    }

    public void setTotalElementCount(long totalElementCount) {
        this.totalElementCount = totalElementCount;
    }

    public  String format(){
        if(this.nodeList==null)return "";
        StringBuffer strPage = new StringBuffer() ;
        for (Node node:this.nodeList)
            strPage.append(node) ;
        return strPage.toString();
    }


}
