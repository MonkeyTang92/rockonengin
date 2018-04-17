package com.rockonengin.model.protocol.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/18.
 */
public class BaseResponse implements Serializable {
    private Integer result;
    private String message;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
