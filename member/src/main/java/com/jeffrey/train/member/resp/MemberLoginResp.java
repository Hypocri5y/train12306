package com.jeffrey.train.member.resp;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-22 02:16
 * @description:
 **/
public class MemberLoginResp {
    private Long id;

    private String mobile;

    private String token;

    public MemberLoginResp() {
    }

    public MemberLoginResp(Long id, String mobile) {
        this.id = id;
        this.mobile = mobile;
    }

    public MemberLoginResp(Long id, String mobile, String token) {
        this.id = id;
        this.mobile = mobile;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberLoginResp{");
        sb.append("id=").append(id);
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
