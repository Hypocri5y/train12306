package com.jeffrey.train.common.exception;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-20 21:35
 * @description:
 **/
public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("手机号码已存在");

    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BusinessException{");
        sb.append("desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
