package com.jeffrey.train.member.controller;

import com.jeffrey.train.common.resp.CommonResp;
import com.jeffrey.train.member.req.PassengerSaveReq;
import com.jeffrey.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-19 00:18
 * @description:
 **/
@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    private PassengerService passengerService;


    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req){
        passengerService.save(req);
        return new CommonResp<>();
    }

}
