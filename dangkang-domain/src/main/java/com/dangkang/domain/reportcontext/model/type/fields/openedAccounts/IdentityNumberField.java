package com.dangkang.domain.reportcontext.model.type.fields.openedAccounts;

import com.dangkang.domain.reportcontext.util.SuplementColumnLengthUtil;

/**
 * @author Orkesh
 * @date 2023/2/21 12:27
 * 描述 :         身份识别码Field对象
 */
public class IdentityNumberField {

    public static final Integer SH_FORMAT_C_20 = 20 ;

    private String identityNumber ;

    public IdentityNumberField (String originalIdentityNumber) {
        this.identityNumber = SuplementColumnLengthUtil.completeLengthOfC(originalIdentityNumber,
                SH_FORMAT_C_20) ;
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    private String format() {
        return this.identityNumber ;
    }
}
