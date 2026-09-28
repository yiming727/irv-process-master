package com.irv.base.exception;

/**
 * @author zqs
 * @version 1.0
 * @description 本项目自定义异常类型
 * @date 2023/2/12 16:56
 */
public class IRVException extends RuntimeException {

    private String errMessage;

    public IRVException() {
    }

    public IRVException(String message) {
        super(message);
        this.errMessage = message;

    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public static void cast(String message){
        throw new IRVException(message);
    }
    public static void cast(CommonError error){
        throw new IRVException(error.getErrMessage());
    }

}
