package com.zpb.dubbo.client.controller;

import com.zpb.dubbo.proto.hello.HelloResponse;
import com.zpb.dubbo.proto.hello.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author       pengbo.zhao
 * @description  hello-controller
 * @createDate   2022/1/18 11:51
 * @updateDate   2022/1/18 11:51
 * @version      1.0
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    DemoService demoService;

    @Resource
    HelloService helloService;

    @GetMapping("h1")
    public String hello(){
        HelloRequest helloRequest = HelloRequest.newBuilder().setName("hello").build();
        log.info("hello-request: {} ",helloRequest.getName());
        HelloReply helloReply = demoService.sayHello(helloRequest);
        return helloReply.getMessage();
    }

    @GetMapping("h2")
    public String hello2()  {
        com.zpb.dubbo.proto.hello.HelloRequest helloRequest = com.zpb.dubbo.proto.hello.HelloRequest.newBuilder().setName("hello").build();
        log.info("name: {} ",helloRequest.getName());
        HelloResponse helloResponse = helloService.sayHello(helloRequest);
        return helloResponse.getMessage();
    }

}
