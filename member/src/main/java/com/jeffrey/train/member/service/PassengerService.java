package com.jeffrey.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.jeffrey.train.common.context.MemberLoginContext;
import com.jeffrey.train.common.util.SnowFlakeUtil;
import com.jeffrey.train.member.domain.Passenger;
import com.jeffrey.train.member.mapper.PassengerMapper;
import com.jeffrey.train.member.req.PassengerSaveReq;
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
public class PassengerService {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(PassengerService.class);
    @Resource
    private PassengerMapper passengerMapper;


    public void save(PassengerSaveReq req) {
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        DateTime now = DateTime.now();
        passenger.setId(MemberLoginContext.getId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

}
