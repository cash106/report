package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject;

import java.util.Date;

/**
 * @author Orkesh
 * @time 2023/2/26 11:44
 *
 * 开户数据 DATA OBJECT （为mybatis映射而存在的）
 */
public class OpenedAccountDO {
    private Long id ;

    private String escrowAccountNumber ;

    private String identityCode ;

    private String fullName ;

    private Date createdDate ;

    public OpenedAccountDO() {
    }

    public OpenedAccountDO(Long id, String escrowAccountNumber, String identityCode, String fullName, Date createdDate) {
        this.id = id;
        this.escrowAccountNumber = escrowAccountNumber;
        this.identityCode = identityCode;
        this.fullName = fullName;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public OpenedAccountDO setId(Long id) {
        this.id = id;
        return this ;
    }

    public String getEscrowAccountNumber() {
        return escrowAccountNumber;
    }

    public OpenedAccountDO setEscrowAccountNumber(String escrowAccountNumber) {
        this.escrowAccountNumber = escrowAccountNumber;
        return this ;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public OpenedAccountDO setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
        return this ;
    }

    public String getFullName() {
        return fullName;
    }

    public OpenedAccountDO setFullName(String fullName) {
        this.fullName = fullName;
        return this ;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public OpenedAccountDO setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this ;
    }
}
