package com.ddd.infrastructure.log.datamasking;
/**
 * 脱敏策略接口
 */
public interface MaskStrategy {

    String mask(String source, int[] params);
}
