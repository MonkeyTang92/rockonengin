package com.rockonengin.common.exception;

/**
 * Created by tangfan on 2017/12/3.
 */
public class ResultCode {

    public final static int RESULT_SYS_EXCEPTION = -1; //系统异常
    public final static int RESULT_SUCCESS = 0; //成功
    public final static int RESULT_NO_PERMISSIONS = 1; //权限不足
    public final static int RESULT_PARAMS_NOT_CORRECT = 2; //参数不符合要求
    public final static int RESULT_NOT_FOUND_RECORD = 3; //没有满足条件的记录
    public final static int RESULT_BUSINESS_FAIL = 99; //其它业务处理失败
}
