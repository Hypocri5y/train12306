package com.jeffrey.train.member.req;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-20 21:10
 * @description:
 **/
public class MemberRegisterReq {
    // 使用Spring Validation进行参数校验
    // 注意：需要在调用该封装类作为Controller传入参数的参数前加@Valid才可生效
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberRegisterReq{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
