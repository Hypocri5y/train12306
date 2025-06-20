package com.jeffrey.train.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-21 01:43
 * @description:
 **/
public class SnowFlakeUtil {
    private static long workerId = 1;
    private static long datercenterId = 1;

    public static long getSnowFlakeNextId() {
        return IdUtil.getSnowflake(workerId, datercenterId).nextId();
    }

    public static String getSnowFlakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, datercenterId).nextIdStr();
    }
}
