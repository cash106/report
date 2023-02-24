package com.dangkang.domain.reportcontext.model.sh.openedaccounts.node;

import com.dangkang.domain.reportcontext.model.ReportNode;
import com.dangkang.domain.reportcontext.model.sh.openedaccounts.field.DateField;
import com.dangkang.domain.reportcontext.model.sh.openedaccounts.field.EscrowAccountField;
import com.dangkang.domain.reportcontext.model.sh.openedaccounts.field.IdentityNumberField;
import com.dangkang.domain.reportcontext.model.sh.openedaccounts.field.InvestorFullnameField;

import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 13:36
 * 描述 :         开户数据 Node 对象
 */
public class OpenedAccountNode extends ReportNode {
    /* 二级托管账号 */
    private EscrowAccountField escrowAccountNumber;
    /* 身份识别码 */
    private IdentityNumberField identityCode;
    /* 投资人全称 */
    private InvestorFullnameField investorFullName ;
    /* 开户日期 */
    private DateField createdDate;

    public OpenedAccountNode setEscrowAccountNumber(String escrowAccountNumber) {
        this.escrowAccountNumber = new EscrowAccountField(escrowAccountNumber) ;
        return this ;
    }

    public OpenedAccountNode setIdentityCode(String identityCode) {
        this.identityCode = new IdentityNumberField(identityCode) ;
        return this ;
    }

    public OpenedAccountNode setInvestorFullName(String investorFullName) {
        this.investorFullName = new InvestorFullnameField(investorFullName) ;
        return this ;
    }

    public OpenedAccountNode setCreatedDate(Date createdDate) {
        this.createdDate = new DateField(createdDate) ;
        return this ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return  new StringBuffer() .append(createdDate).
                                                    append(escrowAccountNumber).
                                                    append(identityCode).
                                                    append(investorFullName).
                                                    append(this.newLine()) .toString();
    }
}
