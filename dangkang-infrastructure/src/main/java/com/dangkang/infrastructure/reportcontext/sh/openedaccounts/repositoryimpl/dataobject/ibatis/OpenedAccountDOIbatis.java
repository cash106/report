package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject.ibatis;

import java.util.Date;

/**
 * @author Orkesh
 * @time 2023/2/26 11:44
 *
 * 开户数据 DATA OBJECT （为mybatis映射而存在的）
 */
public class OpenedAccountDOIbatis {
    private Long id ;

    private String escrowAccountNumber ;

    private String identityCode ;

    private String fullName ;

    private Date createdDate ;

    public OpenedAccountDOIbatis() {
    }

    public OpenedAccountDOIbatis(Long id, String escrowAccountNumber, String identityCode, String fullName, Date createdDate) {
        this.id = id;
        this.escrowAccountNumber = escrowAccountNumber;
        this.identityCode = identityCode;
        this.fullName = fullName;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEscrowAccountNumber() {
        return escrowAccountNumber;
    }

    public void setEscrowAccountNumber(String escrowAccountNumber) {
        this.escrowAccountNumber = escrowAccountNumber;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
