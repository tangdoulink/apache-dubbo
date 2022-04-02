package com.zpb.dubbo.client.controller;

import com.zpb.dubbo.proto.hello.HelloResponse;
import com.zpb.dubbo.proto.hello.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author       pengbo.zhao
 * @description  hello-controller
 * @createDate   2022/1/18 11:51
 * @updateDate   2022/1/18 11:51
 * @version      1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     * interfaceClass: 接口类名
     * interfaceName ：接口全路径名
     * version : 服务版本号
     * group : 服务组
     * url ： 直接调用的服务目标URL，如果指定，则注册中心无效。号称直连
     * client : 客户端传输类型，默认值为"netty"
     * check: 启动时检查服务提供者是否可用，默认值为 true
     * init : 设置所有属性时是否急切初始化引用bean，默认值为true（null为true）
     * lazy : 客户端创建时是否建立连接，默认值为false
     * stubevent : 导出用于事件调度的存根服务，默认值为 false, 详见常量类：{@link org.apache.dubbo.rpc.Constants#STUB_EVENT_METHODS_KEY}
     * reconnect : 断线是否重连，不指定则默认开启重连，重试间隔2000毫秒,详见常量类：{@link org.apache.dubbo.remoting.Constants#DEFAULT_RECONNECT_PERIOD}
     * sticky : 是否粘在集群中的同一个节点上，默认值为false. 详见常量类：{@link org.apache.dubbo.rpc.cluster.Constants#DEFAULT_CLUSTER_STICKY}
     * proxy : 代理是如何生成的，合法值包括：jdk、javassist
     * stub : 服务存根名称，如果未设置，则使用接口名称 + 本地
     * cluster : 集群策略，合法值包括：failover、failfast、failsafe、failback、fork, 详见常量类：{@link org.apache.dubbo.common.constants.ClusterRules#FAIL_OVER}
     * connections : 服务提供者可以接受的最大连接数，默认值为 0 - 连接是共享的
     * callbacks : 回调实例限制对等连接. 详见常量类：{@link org.apache.dubbo.common.constants.CommonConstants#DEFAULT_CALLBACK_INSTANCES }
     * onconnect ： 连接时回调方法名，默认为空字符串
     * ondisconnect ：断开连接时的回调方法名称，默认值为空字符串
     * owner ： 服务所有者，默认值为空字符串
     * layer ：服务层，默认值为空字符串
     * retries ： 服务调用重试次数，详见常量类：{@link org.apache.dubbo.common.constants.CommonConstants#DEFAULT_RETRIES }
     * loadbalance : 负载均衡 其它策略详见：{@link org.apache.dubbo.common.constants.LoadbalanceRules#RANDOM}
     * async : 是否开启异步调用，默认为false
     * actives : 允许的最大活动请求数，默认值为 -1
     * sent : 异步请求是否已经发送，默认值为 false
     * mock : 服务模拟名，不设置使用接口名+Mock
     * validation : 是否使用JSR303验证，合法值为：true、false
     * timeout : 服务调用的超时值，默认值为 0
     * cache : 指定服务调用的缓存实现，合法值包括：lru、threadlocal、jcache
     * filter : 服务调用过滤器
     * listener : 服务导出和取消导出的监听器
     * parameters : 自定义参数键值对，例如：{key1, value1, key2, value2} 或 {"key1=value1", "key2=value2"}
     * module :  模块关联名称
     * consumer : 消费者关联名称
     * monitor :  监控关联名称
     * registry : 注册表关联名称
     * protocol : Dubbo Service的通信协议,从2.6.6开始
     * tag : 服务标签名称
     * merger : 服务合并
     * methods : 支持的方法
     * id : 在 @Bean 方法上使用 @DubboReference 时忽略 id 属性
     * providedBy : 声明该接口属于哪个应用或服务 {@link  org.apache.dubbo.common.constants.RegistryConstants#PROVIDED_BY  }
     * scope : 引用服务的范围，如果是本地的，则表示仅在当前JVM中搜索,可选值有：{@link org.apache.dubbo.rpc.Constants#SCOPE_LOCAL,org.apache.dubbo.rpc.Constants#SCOPE_REMOTE}
     * referAsync : 引用是否是异步引用
     */

    @DubboReference(scope = "remote",check = false,version = "1.0.0",protocol = "tri")
    DemoService demoService;

    @DubboReference(scope = "remote",check = false,version = "1.0.0",protocol = "dubbo")
    HelloService helloService;

    @GetMapping("h1")
    public String hello(){
        HelloRequest helloRequest = HelloRequest.newBuilder().setName("hello").build();

        System.err.println("hello-request: "+ helloRequest.getName());
        HelloReply helloReply = demoService.sayHello(helloRequest);
        return helloReply.getMessage();
    }

    @GetMapping("h2")
    public String hello2()  {
        com.zpb.dubbo.proto.hello.HelloRequest helloRequest = com.zpb.dubbo.proto.hello.HelloRequest.newBuilder().setName("hello").build();
        System.err.println("name: "+helloRequest.getName());
        HelloResponse helloResponse = helloService.sayHello(helloRequest);
        return helloResponse.getMessage();
    }

}
