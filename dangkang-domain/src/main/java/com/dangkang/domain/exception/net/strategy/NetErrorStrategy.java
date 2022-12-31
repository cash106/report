package com.dangkang.domain.exception.net.strategy;

import com.dangkang.domain.exception.net.NetError;
import com.dangkang.domain.exception.net.NetErrorContext;

/**
 * @author anzj
 * @date 2022/12/20 15:39
 */
public interface NetErrorStrategy {

    NetError parseNetError(NetErrorContext context);

    boolean accept(Throwable t);
}
