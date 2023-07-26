package com.gsl.video;

import com.gsl.common.swagger.annotation.EnableKnife4jConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fandeshan
 * @description 视频服务
 * @date 2023/4/26
 */
@EnableKnife4jConfig
@EnableDiscoveryClient
@MapperScan("com.gsl.video.core.**.mapper")//扫描 **mapper.java 的bean
@SpringBootApplication(scanBasePackages = {"com.gsl.video"})
public class VideoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

}
