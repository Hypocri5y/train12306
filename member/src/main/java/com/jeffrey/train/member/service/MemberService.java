package com.jeffrey.train.member.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.jeffrey.train.common.exception.BusinessException;
import com.jeffrey.train.common.exception.BusinessExceptionEnum;
import com.jeffrey.train.common.util.SnowFlakeUtil;
import com.jeffrey.train.member.domain.Member;
import com.jeffrey.train.member.domain.MemberExample;
import com.jeffrey.train.member.mapper.MemberMapper;
import com.jeffrey.train.member.req.MemberRegisterReq;
import com.jeffrey.train.member.req.MemberSendCodeReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-19 00:17
 * @description:
 **/
@Service
public class MemberService {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MemberService.class);
    @Resource
    private MemberMapper memberMapper;

    public Long count()
    {
        return memberMapper.countByExample(null);
    }

    public long register(MemberRegisterReq req) {
        // 查询手机号是否已经被注册
        // memberexample类即查询条件
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        // 也可使用hutool的CollUtil.isNotEmpty(list)判空
        if (!(null == list || list.isEmpty())) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(SnowFlakeUtil.getSnowFlakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
    public String sendCode(MemberSendCodeReq req) {
        // 查询手机号是否已经被注册
        // memberexample类即查询条件
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        // 若手机号未被注册，自动注册
        if (CollUtil.isEmpty(list)) {
            LOG.info("手机验证码：{}，请求，该手机号不存在，自动注册",mobile);
            Member member = new Member();
            member.setId(SnowFlakeUtil.getSnowFlakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }
        else{
            LOG.info("手机验证码：{}，请求",mobile);
        }
        // 生成短信验证码
        String code = RandomUtil.randomString(6);
        LOG.info("手机验证码：{}，生成验证码：{}",mobile,code);
        // 保存短信验证码记录（略）。数据表结构：手机号、验证码、有效期、是否已使用、业务类型、发送时间、使用时间
        LOG.info("手机验证码：{}，保存到短信验证码记录表",mobile);
        // 对接短信发送平台（略）
        LOG.info("手机验证码：{}，短信发送平台发送成功",mobile);
        return code;
    }
}
