package com.luziye.bootluanch.exception;

public class CustomException extends RuntimeException {
    //异常错误编码
    private int code ;
    //异常信息
    private String message;

    public CustomException(CustomExceptionType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}