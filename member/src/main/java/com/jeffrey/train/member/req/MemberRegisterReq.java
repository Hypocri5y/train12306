package com.jeffrey.train.member.req;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-20 21:10
 * @description:
 **/
public class MemberRegisterReq {
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
