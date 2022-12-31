package com.dangkang.infrastructure.external;

import java.math.BigDecimal;

/**
 * @author anzj
 * @date 2022/12/20 17:37
 */
public class ExternalRequest {

    private String orderId;
    private String sourceAccount;//付款账户
    private String targetAccount;//收款账户
    private BigDecimal amount;//支付金额

    public String getSourceAccount() {
        return sourceAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
