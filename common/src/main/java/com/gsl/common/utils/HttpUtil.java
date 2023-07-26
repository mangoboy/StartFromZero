package com.gsl.common.utils;

import com.alibaba.fastjson2.JSONObject;
import com.gsl.common.exception.CustomException;
import com.gsl.common.result.enums.ResultCode;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author taojirun
 * @description http请求工具类
 * @create 2023/4/26 18:31
 */
@Slf4j
@Component
public class HttpUtil {


    /**
     * @param url
     * @param paramMap
     * @return java.lang.String
     * @description 处理get请求路径
     * @author taojirun
     * @date 15:44 2023/5/6
     **/
    private static String dealGetUrl(String url, Map<String, String> paramMap) {
        if (StringUtils.isBlank(url) || CollectionUtils.isEmpty(paramMap)) {
            return url;
        }
        StringBuilder sb = new StringBuilder(url);
        paramMap.forEach((k, v) -> {
            sb.append("&").append(k).append("=").append(v);
        });
        sb.replace(url.length(), url.length() + 1, "?");
        return sb.toString();
    }

    /**
     * @param url
     * @param headers
     * @param paramMap
     * @return com.gsl.common.result.ResultInfo
     * @description post请求
     * @author taojirun
     * @date 15:15 2023/5/4
     **/
    @Synchronized
    public String post(String url, Header[] headers, Map<String, String> paramMap) {
        String resultStr = null;
        try {
            log.info("===request url:{}", url);
            log.info("===request body:{}", paramMap);
            log.info("===request header:{}", headers);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeaders(headers);
            httpPost.setEntity(new StringEntity(JSONObject.toJSONString(paramMap), ContentType.APPLICATION_JSON.getMimeType(), HTTP.UTF_8));
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                resultStr = EntityUtils.toString(entity);
            }
            log.info("===response body:{}", resultStr);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CustomException(ResultCode.SYSTEM_ERROR.getCode(), "系统异常");
        }
        return resultStr;
    }


    /**
     * @param url
     * @param headers
     * @param paramMap
     * @return com.gsl.common.result.ResultInfo
     * @description get请求
     * @author taojirun
     * @date 15:56 2023/5/6
     **/
    @Synchronized
    public String get(String url, Header[] headers, Map<String, String> paramMap) {
        String resultStr = null;
        try {
            log.info("===request url:{}", url);
            log.info("===request body:{}", paramMap);
            log.info("===request header:{}", headers);
            HttpGet httpGet = new HttpGet(dealGetUrl(url, paramMap));
            httpGet.setHeaders(headers);
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                resultStr = EntityUtils.toString(entity);
            }
            log.info("===response body:{}", resultStr);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CustomException(ResultCode.SYSTEM_ERROR.getCode(), "系统异常");
        }
        return resultStr;

    }


}
