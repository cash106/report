package com.dangkang.client.dto.protocol.response;

/**
 * @author anzj
 * @date 2022/12/19 17:07
 */
public class ApplicationServiceResponse {

    private String type;
    private String code;
    private String message;
    private String investorName;
    private String bondCode;
    private String holdingQuota;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getHoldingQuota() {
        return holdingQuota;
    }

    public void setHoldingQuota(String holdingQuota) {
        this.holdingQuota = holdingQuota;
    }
}
