package com.zpb.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author       pengbo.zhao
 * @description  主启动类
 * @createDate   2022/1/18 14:06
 * @updateDate   2022/1/18 14:06
 * @version      1.0
 */
@EnableDubbo
@SpringBootApplication
@ImportResource(locations = {"classpath:/spring/dubbo-provider.xml"})
public class ApacheDubboXmlServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApacheDubboXmlServiceApplication.class,args);
    }

}
