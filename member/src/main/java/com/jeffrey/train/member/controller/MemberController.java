package com.jeffrey.train.member.controller;

import com.jeffrey.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-19 00:18
 * @description:
 **/
@RestController
public class MemberController {

    @Resource
    private MemberService memberService;


    @GetMapping("/count")
    public Long count()
    {
        return memberService.count();
    }

    @PostMapping("/register")
    public long register(String mobile){
        return memberService.register(mobile);
    }
}
