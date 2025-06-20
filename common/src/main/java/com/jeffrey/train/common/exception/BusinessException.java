package com.jeffrey.train.common.exception;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-20 21:40
 * @description:
 **/
public class BusinessException extends RuntimeException{
    private BusinessExceptionEnum exceptionEnum;

    public BusinessException(BusinessExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public BusinessExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(BusinessExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BusinessException{");
        sb.append("exceptionEnum=").append(exceptionEnum);
        sb.append('}');
        return sb.toString();
    }

    // 不写入堆栈信息，提高性能
    @Override
    public Throwable fillInStackTrace(){
        return this;
    }
}
