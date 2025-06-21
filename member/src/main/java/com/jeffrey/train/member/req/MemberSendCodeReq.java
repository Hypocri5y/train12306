package com.jeffrey.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-21 03:56
 * @description:
 **/
public class MemberSendCodeReq {
    @NotBlank(message = "手机号不能为空")
    // 使用正则表达式对手机号格式进行参数校验
    @Pattern(regexp = "^1\\d{10}$", message = "手机号码格式错误")
    private String mobile;
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberSendCodeReq{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
