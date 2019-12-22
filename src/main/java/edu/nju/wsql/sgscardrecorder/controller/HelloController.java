package edu.nju.wsql.sgscardrecorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "hello测试")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    @ApiOperation(value = "获取hello测试结果")
    public String hello() {
        return "Hello, this is a 三国杀 card recorder.";
    }
}
