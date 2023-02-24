package com.dangkang.infrastructure.reportcontext.sh.openedaccounts.repositoryimpl.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/23 9:11
 * 描述 :         业务系统的数据库会将开户记录数据保存到Acclog为名的数据库表中。
 *               本DO（data object）是为了和持久化机制中的行适配对应而存在的
 */
@Entity(name = "tb_account_log")
public class OpenedAccountDO {
    @Id
    private Long id ; //数据库自增主键提供的DO唯一标识

    @Column(name = "escrow_account_number")
    private String escrowAccountNumber ; //数据库表中的字段（存储二级托管账号）

    @Column(name = "identity_code")
    private String identityCode ; // 身份识别码

    @Column(name = "full_name")
    private String fullName ; //投资人全称

    @Column(name = "created_date")
    private Date createdDate ; //落库（被记录）时间

    /* 很多ORM工具一般都需要我们的 DATA OBJECT 提供一个空构造函数 */
    public OpenedAccountDO() {
    }

    public OpenedAccountDO(String escrowAccountNumber, String identityCode, String fullName, Date createDate) {
        this.escrowAccountNumber = escrowAccountNumber;
        this.identityCode = identityCode;
        this.fullName = fullName;
        this.createdDate = createDate;
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

    public Date getCreateDate() {
        return createdDate;
    }

    public void setCreateDate(Date createDate) {
        this.createdDate = createDate;
    }
}
