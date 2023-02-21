package com.dangkang.domain.reportcontext.model.openedaccounts.field;

import com.dangkang.domain.reportcontext.model.Field;
import com.dangkang.domain.reportcontext.model.util.FieldFormat;

/**
 * @author Orkesh
 * @date 2023/2/21 13:29
 * 描述 :         投资人全称 Field 对象
 */
public class InvestorFullnameField implements Field {

    public static final Integer SH_FORMAT_C_200 = 200 ;

    private String investorFullName ;

    public InvestorFullnameField(String originalFullname ) {
        this.investorFullName = FieldFormat.rightFillFormat(originalFullname,
                SH_FORMAT_C_200) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    public String format() {
        return this.investorFullName ;
    }
}
