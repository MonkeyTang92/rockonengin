package com.rockonengin.common.exception;

import org.springframework.core.NestedRuntimeException;

public class RockonenginWebException extends NestedRuntimeException {

    private String errorCode;

    public RockonenginWebException(String msg) {
        super(msg);
    }

    public RockonenginWebException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RockonenginWebException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public RockonenginWebException(String errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
