    package com.zpb.dubbo.proto.hello;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

@javax.annotation.Generated(
value = "by Dubbo generator",
comments = "Source: hello.proto")
public interface HelloService {
static final String JAVA_SERVICE_NAME = "com.zpb.dubbo.proto.hello.HelloService";
static final String SERVICE_NAME = "com.zpb.dubbo.proto.hello.HelloService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = HelloServiceDubbo.init();

    com.zpb.dubbo.proto.hello.HelloResponse sayHello(com.zpb.dubbo.proto.hello.HelloRequest request);

    CompletableFuture<com.zpb.dubbo.proto.hello.HelloResponse> sayHelloAsync(com.zpb.dubbo.proto.hello.HelloRequest request);


}
