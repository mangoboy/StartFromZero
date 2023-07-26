package com.gsl.gatewayservice.controller;

import com.gsl.gatewayservice.provider.Knife4jResourceProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;

/**
 * @Description
 * @Author taojirun
 * @create 2023/5/5 14:30
 */
@RestController
@RequestMapping("/swagger-resources")
@RequiredArgsConstructor
public class Knife4jResourceController {

    private final Knife4jResourceProvider knife4jResourceProvider;

    @RequestMapping
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity<>(knife4jResourceProvider.get(), HttpStatus.OK);
    }
}

