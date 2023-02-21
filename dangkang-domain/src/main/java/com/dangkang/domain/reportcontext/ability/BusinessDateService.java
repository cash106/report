package com.dangkang.domain.reportcontext.ability;

import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/21 14:15
 * 描述 :         为了号召业务管理系统的规则要求，系统当中所有和业务日期等有关的时间须从数据库获取，
 *                  故在领域层声明了此领域服务（更多的是领域层对外的一种期望）
 */
public interface BusinessDateService {

    public Date businessDate() ;
}
