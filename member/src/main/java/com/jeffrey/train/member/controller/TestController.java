package com.jeffrey.train.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2025-06-16 00:05
 * @description:
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Word!";
    }
}
