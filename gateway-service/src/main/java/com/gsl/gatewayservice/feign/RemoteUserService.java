package com.gsl.gatewayservice.feign;

import com.gsl.common.constants.ServiceNameConstants;
import com.gsl.common.result.ResultInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 用户服务
 * @Author taojirun
 * @create 2023/5/5 20:32
 */
@Component
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.USER_SERVICE, path = ServiceNameConstants.USER_SERVICE)
public interface RemoteUserService {

    /**
     * 校验token
     */
    @GetMapping(value = "/verifyToken")
    ResultInfo verifyToken(@RequestParam("token") String token);

}
