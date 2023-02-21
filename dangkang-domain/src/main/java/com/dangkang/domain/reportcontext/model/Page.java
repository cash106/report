package com.dangkang.domain.reportcontext.model;

import java.util.List;

public class Page {

    private int size =100;

    private int currentPage;

    private int count;

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

    public int getCount() {
        return count;
    }

    public Page setCount(int count) {
        this.count = count;
        return this;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public Page setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
        return this;
    }

    public  String format(){
        if(this.nodeList==null)return "";
        StringBuffer strPage = new StringBuffer() ;
        for (Node node:this.nodeList)
            strPage.append(node) ;
        return strPage.toString();
    }


}
