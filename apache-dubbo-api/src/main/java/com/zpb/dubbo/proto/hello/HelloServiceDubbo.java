    package com.zpb.dubbo.proto.hello;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

@javax.annotation.Generated(
value = "by Dubbo generator",
comments = "Source: hello.proto")
public final class HelloServiceDubbo {
private static final AtomicBoolean registered = new AtomicBoolean();

public static boolean init() {
    if (registered.compareAndSet(false, true)) {
            org.apache.dubbo.common.serialize.protobuf.support.ProtobufUtils.marshaller(
            com.zpb.dubbo.proto.hello.HelloRequest.getDefaultInstance());
            org.apache.dubbo.common.serialize.protobuf.support.ProtobufUtils.marshaller(
            com.zpb.dubbo.proto.hello.HelloResponse.getDefaultInstance());
    }
    return true;
}

private HelloServiceDubbo() {}

}
