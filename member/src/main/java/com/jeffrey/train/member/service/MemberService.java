package com.jeffrey.train.member.service;

import com.jeffrey.train.member.domain.Member;
import com.jeffrey.train.member.domain.MemberExample;
import com.jeffrey.train.member.mapper.MemberMapper;
import com.jeffrey.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

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
            throw new RuntimeException("手机号已注册");
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
