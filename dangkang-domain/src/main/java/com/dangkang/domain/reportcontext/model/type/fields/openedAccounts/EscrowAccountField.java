package com.dangkang.domain.reportcontext.model.type.fields.openedAccounts;

import com.dangkang.domain.reportcontext.util.SuplementColumnLengthUtil;

/**
 * @author Orkesh
 * @date 2023/2/21 13:10
 * 描述 :         二级托管账号Field对象
 */
public class EscrowAccountField {

    public static final Integer SH_FORMAT_C_18 = 18 ;

    private String escrowAccount ;

    public EscrowAccountField(String originalEscrowAccount) {
        this.escrowAccount = SuplementColumnLengthUtil.completeLengthOfC(originalEscrowAccount,
                SH_FORMAT_C_18) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    private String format() {
        return this.escrowAccount ;
    }
}
