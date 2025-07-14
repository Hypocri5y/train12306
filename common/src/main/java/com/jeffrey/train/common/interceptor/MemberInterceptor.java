package com.jeffrey.train.common.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jeffrey.train.common.context.MemberLoginContext;
import com.jeffrey.train.common.resp.MemberLoginResp;
import com.jeffrey.train.common.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-07-15 06:07
 * @description:
 **/
@Component
public class MemberInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(MemberInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("### MemberInterceptor开始 ###");
        // 获取header的token参数
        String token = request.getHeader("token");
        if (StrUtil.isNotBlank(token)) {
            LOG.info("获取会员登录token：{}", token);
            JSONObject loginMember = JWTUtil.getJSONObject(token);
            LOG.info("当前登录会员：{}", loginMember);
            // 根据token还原后的字段生成登录信息类
            MemberLoginResp member = JSONUtil.toBean(loginMember, MemberLoginResp.class);
            // 只要当前线程完成上述过程，即将登录信息保存在该线程的本地变量中
            MemberLoginContext.setMember(member);
        }
        LOG.info("### MemberInterceptor结束 ###");
        return true;
    }
}
