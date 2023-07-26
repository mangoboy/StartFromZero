package com.gsl.common.swagger.porp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description Knife4j配置
 * @Author taojirun
 * @create 2023/5/3 22:58
 */
@Data
@Component
@ConfigurationProperties(prefix = "knife4j.prop")
public class Knife4jProp {

    private String description = "Knife4j RESTful APIs";

    private String termsOfServiceUrl = "https://doc.123.com/";

    private String version = "v1.0";

    private String groupName = "视频服务";

    private String basePackage = "com.gsl.video";


}