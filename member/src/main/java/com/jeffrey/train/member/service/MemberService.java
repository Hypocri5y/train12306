package com.jeffrey.train.member.service;

import cn.hutool.core.util.IdUtil;
import com.jeffrey.train.common.exception.BusinessException;
import com.jeffrey.train.common.exception.BusinessExceptionEnum;
import com.jeffrey.train.common.util.SnowFlakeUtil;
import com.jeffrey.train.member.domain.Member;
import com.jeffrey.train.member.domain.MemberExample;
import com.jeffrey.train.member.mapper.MemberMapper;
import com.jeffrey.train.member.req.MemberRegisterReq;
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
}
