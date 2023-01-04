package com.dangkang.domain.exception;

/**
 * @date 2022/12/19 11:05
 */
public class ApplicationException extends RuntimeException {

    private String errorCode;
    private String promptMessage;
    private String detailMessage;
    private Throwable cause;

    public ApplicationException(){}

    public ApplicationException setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ApplicationException setPromptMessage(String promptMessage,String... values) {
        this.promptMessage = String.format(promptMessage,values);
        return this;
    }

    public ApplicationException setDetailMessage(String detailMessage,String... values) {
        this.detailMessage = String.format(detailMessage,values);
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public Throwable getCause() {
        return cause;
    }

    public ApplicationException setCause(Throwable cause) {
        this.cause = cause;
        return this;
    }
}
