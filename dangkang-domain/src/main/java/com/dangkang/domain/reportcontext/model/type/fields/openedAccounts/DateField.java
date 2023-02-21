package com.dangkang.domain.reportcontext.model.type.fields.openedAccounts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 13:32
 * 描述 :         日期Field对象
 */
public class DateField {

    public static final String SH_FORMAT_DATE = "yyyyMMdd" ;

    private String openedDate ;

    public DateField(Date originalOpenedDate) {
        this.openedDate = new SimpleDateFormat(SH_FORMAT_DATE).format(originalOpenedDate);
    }

    @Override
    public String toString() {
        return this.format() ;
    }

    private String format() {
        return this.openedDate ;
    }
}
