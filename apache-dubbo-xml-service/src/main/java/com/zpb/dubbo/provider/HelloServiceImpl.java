package com.zpb.dubbo.provider;

import com.zpb.dubbo.proto.hello.HelloRequest;
import com.zpb.dubbo.proto.hello.HelloResponse;
import com.zpb.dubbo.proto.hello.HelloService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author       pengbo.zhao
 * @description  hello-service-provider
 * @createDate   2022/1/19 16:48
 * @updateDate   2022/1/19 16:48
 * @version      1.0
 */

public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public HelloResponse sayHello(HelloRequest request) {

        logger.info("sayHello {} , request from consumer: {} ",request.getName(),RpcContext.getServerContext().getRemoteAddress());
        return HelloResponse.newBuilder()
                .setMessage("sayHello " + request.getName() + ", response from provider: "
                        + RpcContext.getServerContext().getRemoteAddress())
                .build();
    }

    @Override
    public CompletableFuture<HelloResponse> sayHelloAsync(HelloRequest request) {
        return CompletableFuture.completedFuture(sayHello(request));
    }

}
