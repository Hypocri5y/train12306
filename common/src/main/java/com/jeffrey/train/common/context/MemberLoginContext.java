package com.jeffrey.train.common.context;

import com.jeffrey.train.common.resp.MemberLoginResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-07-15 06:04
 * @description:
 **/
public class MemberLoginContext {
    private static final Logger LOG = LoggerFactory.getLogger(MemberLoginContext.class);

    private static ThreadLocal<MemberLoginResp> member = new ThreadLocal<>();

    public static MemberLoginResp getMember() {
        return member.get();
    }

    public static void setMember(MemberLoginResp member) {
        MemberLoginContext.member.set(member);
    }

    public static Long getId() {
        try {
            return member.get().getId();
        } catch (Exception e) {
            LOG.error("获取用户登录信息异常", e);
            throw e;
        }
    }
}