package com.dangkang.infrastructure.reportcontext;

import com.dangkang.domain.reportcontext.ability.BusinessDateService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Orkesh
 * @date 2023/2/23 10:40
 * 描述 :
 */
@Component
public class BusinessDateServiceImpl implements BusinessDateService {
    @Override
    public Date businessDate() {
        return new Date();
    }
}
