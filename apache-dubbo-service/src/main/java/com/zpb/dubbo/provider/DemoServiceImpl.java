package com.zpb.dubbo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author       pengbo.zhao
 * @description  DubboService 注解属性
 * @createDate   2022/1/18 13:54
 * @updateDate   2022/1/18 13:54
 * @version      1.0
 *
 * <P>
 *     DubboService 注解属性
 *          interfaceClass ： 接口类，默认值为void.class
 *          interfaceName  ： 接口类名，默认值为空字符串
 *          version : 服务版本，默认值为空字符串
 *          group : 服务组
 *          path : 服务路径，默认为空字符串
 *          export : 是否暴露服务，默认值为true
 *          token : 服务令牌，默认值为 false
 *          deprecated : 服务是否被弃用，默认值为 false
 *          dynamic : 服务是否动态，默认值为true
 *          accesslog : 服务的访问日志，默认值为""
 *          executes : 服务的最大并发执行次数，默认值为 0 - 无限制
 *          register : 是否注册服务到注册中心，默认为true
 *          weight : 服务权重值，默认值为0
 *          document : 服务文档，默认值为""
 *          delay : 服务注册延迟时间，默认0
 *          stub : 服务存根名称，如果未设置，则使用接口名称 + 本地
 *          cluster : 集群策略，合法值包括：failover、failfast、failsafe、failback、fork, 详见常量类：{@link org.apache.dubbo.common.constants.ClusterRules#FAIL_OVER}
 *          proxy : 代理是如何生成的，合法值包括：jdk、javassist
 *          connections : 服务提供者可以接受的最大连接数，默认值为 0 - 连接是共享的
 *          callbacks : 回调实例限制对等连接. 详见常量类：{@link org.apache.dubbo.common.constants.CommonConstants#DEFAULT_CALLBACK_INSTANCES }
 *          onconnect ： 连接时回调方法名，默认为空字符串
 *          ondisconnect ：断开连接时的回调方法名称，默认值为空字符串
 *          owner ： 服务所有者，默认值为空字符串
 *          layer ：服务层，默认值为空字符串
 *          retries ： 服务调用重试次数，详见常量类：{@link org.apache.dubbo.common.constants.CommonConstants#DEFAULT_RETRIES }
 *          loadbalance : 负载均衡 其它策略详见：{@link org.apache.dubbo.common.constants.LoadbalanceRules#RANDOM}
 *          async : 是否开启异步调用，默认为false
 *          actives : 允许的最大活动请求数，默认值为 -1
 *          sent : 异步请求是否已经发送，默认值为 false
 *          mock : 服务模拟名，不设置使用接口名+Mock
 *          validation : 是否使用JSR303验证，合法值为：true、false
 *          timeout : 服务调用的超时值，默认值为 0
 *          cache : 指定服务调用的缓存实现，合法值包括：lru、threadlocal、jcache
 *          filter : 服务调用过滤器
 *          listener : 服务导出和取消导出的监听器
 *          parameters : 自定义参数键值对，例如：{key1, value1, key2, value2} 或 {"key1=value1", "key2=value2"}
 *          module :  模块关联名称
 *          provider : 提供者 spring bean 名称
 *          protocol : 协议 spring bean 名称
 *          monitor :  监控spring bean名称
 *          registry : 注册表spring bean名称
 *          tag : 服务标签名称
 *          methods : 支持的方法
 *          scope : 引用服务的范围，如果是本地的，则表示仅在当前JVM中搜索,可选值有：{@link org.apache.dubbo.rpc.Constants#SCOPE_LOCAL,org.apache.dubbo.rpc.Constants#SCOPE_REMOTE}
 *          exportAsync : 是否暴露异步服务
 *
 * </P>
 *
 *
 */
@Service
@DubboService(version = "1.0.0",protocol = "default-protocol,demo-protocol")
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public HelloReply sayHello(HelloRequest request) {
        logger.info("Hello " + request.getName() + ", request from consumer: " + RpcContext.getServerContext().getRemoteAddress());

        return HelloReply.newBuilder()
                .setMessage("Hello " + request.getName() + ", response from provider: "
                        + RpcContext.getServerContext().getRemoteAddress())
                .build();
    }

    @Override
    public CompletableFuture<HelloReply> sayHelloAsync(HelloRequest request) {
        return CompletableFuture.completedFuture(sayHello(request));
    }

}
