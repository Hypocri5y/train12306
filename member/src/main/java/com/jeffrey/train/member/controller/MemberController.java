package com.jeffrey.train.member.controller;

import com.jeffrey.train.common.resp.CommonResp;
import com.jeffrey.train.member.req.MemberLoginReq;
import com.jeffrey.train.member.req.MemberRegisterReq;
import com.jeffrey.train.member.req.MemberSendCodeReq;
import com.jeffrey.train.member.resp.MemberLoginResp;
import com.jeffrey.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-19 00:18
 * @description:
 **/
@RestController("/member")
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;


    @GetMapping("/count")
    public CommonResp<Long> count()
    {
        Long count = memberService.count();

        return new CommonResp<>(count);
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req){
        Long count = memberService.register(req);

        return new CommonResp<>(count);
    }
    @PostMapping("/send-code")
    public CommonResp sendCode(@Valid @RequestBody MemberSendCodeReq req){
        CommonResp commonResp = memberService.sendCode(req);
        return commonResp;
    }
    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req){
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }
}
