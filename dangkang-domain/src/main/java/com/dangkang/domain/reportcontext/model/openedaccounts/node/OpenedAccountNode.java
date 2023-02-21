package com.dangkang.domain.reportcontext.model.openedaccounts.node;

import com.dangkang.domain.reportcontext.model.ReportNode;
import com.dangkang.domain.reportcontext.model.openedaccounts.field.DateField;
import com.dangkang.domain.reportcontext.model.openedaccounts.field.EscrowAccountField;
import com.dangkang.domain.reportcontext.model.openedaccounts.field.IdentityNumberField;
import com.dangkang.domain.reportcontext.model.openedaccounts.field.InvestorFullnameField;

import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 13:36
 * 描述 :         开户数据 Node 对象
 */
public class OpenedAccountNode extends ReportNode {
    /* 二级托管账号 */
    private EscrowAccountField escrowAccount ;
    /* 身份识别码 */
    private IdentityNumberField identityNumber ;
    /* 投资人全称 */
    private InvestorFullnameField investorFullName ;
    /* 开户日期 */
    private DateField date ;

    public OpenedAccountNode setEscrowAccount(String escrowAccount) {
        this.escrowAccount = new EscrowAccountField(escrowAccount) ;
        return this ;
    }

    public OpenedAccountNode setIdentityNumber(String identityNumber) {
        this.identityNumber = new IdentityNumberField(identityNumber) ;
        return this ;
    }

    public OpenedAccountNode setInvestorFullName(String investorFullName) {
        this.investorFullName = new InvestorFullnameField(investorFullName) ;
        return this ;
    }

    public OpenedAccountNode setDate(Date date) {
        this.date = new DateField(date) ;
        return this ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return  new StringBuffer() .append(date).
                                                    append(escrowAccount).
                                                    append(identityNumber).
                                                    append(investorFullName).
                                                    append(this.newLine()) .toString();
    }
}
