package com.jeffrey.train.member.service;

import com.jeffrey.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

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
}
