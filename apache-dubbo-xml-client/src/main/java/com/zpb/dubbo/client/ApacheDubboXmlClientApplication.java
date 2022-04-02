package com.zpb.dubbo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author       pengbo.zhao
 * @description  主启动类
 * @createDate   2022/1/18 11:49
 * @updateDate   2022/1/18 11:49
 * @version      1.0
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:/spring/dubbo-consumer.xml"})
public class ApacheDubboXmlClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApacheDubboXmlClientApplication.class,args);
    }

}
