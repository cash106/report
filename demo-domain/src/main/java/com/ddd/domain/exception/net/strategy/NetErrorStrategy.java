package com.ddd.domain.exception.net.strategy;

import com.ddd.domain.exception.Error;
import com.ddd.domain.exception.net.NetErrorContext;

/**
 * @author anzj
 * @date 2022/12/20 15:39
 */
public interface NetErrorStrategy {

    Error parseNetError(NetErrorContext context);

    boolean accept(Throwable t);
}
