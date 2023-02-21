package com.dangkang.domain.reportcontext.model.type.fields.openedAccounts;

import com.dangkang.domain.reportcontext.util.SuplementColumnLengthUtil;

/**
 * @author Orkesh
 * @date 2023/2/21 13:29
 * 描述 :         投资人全称 Field 对象
 */
public class InvestorFullnameField {

    public static final Integer SH_FORMAT_C_200 = 200 ;

    private String investorFullName ;

    public InvestorFullnameField(String originalFullname ) {
        this.investorFullName = SuplementColumnLengthUtil.completeLengthOfC(originalFullname,
                SH_FORMAT_C_200) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    private String format() {
        return this.investorFullName ;
    }
}
