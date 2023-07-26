package com.gsl.common.utils;

import com.alibaba.fastjson2.JSON;
import com.gsl.common.constants.IdmUserInfoConstants;
import com.gsl.common.constants.TokenConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息工具类
 *
 * @author taojirun
 **/
public class UserInfoUtil {

    /**
     * 获得用户主键唯一id
     *
     * @param request
     * @return
     */
    public static String getUserId(HttpServletRequest request) {
        String userId = null;
        String token = request.getHeader(TokenConstants.AUTHENTICATION);
        if (StringUtils.isNotBlank(token)) {
            userId = getUserInfo(token).get(IdmUserInfoConstants.USER_ID);
        }
        return userId;
    }


    /**
     * 获取登陆账号
     *
     * @param request
     * @return userName
     */
    public static String getUserAccount(HttpServletRequest request) {
        String userName = null;
        String token = request.getHeader(TokenConstants.AUTHENTICATION);
        if (StringUtils.isNotBlank(token)) {
            userName = getUserInfo(token).get(IdmUserInfoConstants.USER_ACCOUNT);
        }
        return userName;
    }

    /**
     * 获取中文姓名
     *
     * @param request
     * @return
     */
    public static String getUserName(HttpServletRequest request) {
        String name = null;
        String token = request.getHeader(TokenConstants.AUTHENTICATION);
        if (StringUtils.isNotBlank(token)) {
            name = getUserInfo(token).get(IdmUserInfoConstants.USER_NAME);
        }
        return name;
    }


    /**
     * 获取用户角色id 列表
     *
     * @param request
     * @return
     */
    public static List<String> getRoleIds(HttpServletRequest request) {
        String roleIds = "";
        String token = request.getHeader(TokenConstants.AUTHENTICATION);
        if (StringUtils.isNotBlank(token)) {
            roleIds = getUserInfo(token).get(IdmUserInfoConstants.ROLE_IDS);
        }
        if (StringUtils.isNotBlank(roleIds)) {
            return Arrays.asList(roleIds.split(","));
        }
        return null;
    }

    /**
     * 从token第二段信息解析出用户信息map
     *
     * @param token
     * @return
     */
    private static Map<String, String> getUserInfo(String token) {
        Map<String, String> map = new HashMap<>(4);
        try {
            String userInfo = new String(Base64.decodeBase64(token.split("\\.")[1]), "utf-8");
            map = JSON.parseObject(userInfo, Map.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getRoleName(HttpServletRequest request) {
        String roleName = null;
        String token = request.getHeader(TokenConstants.AUTHENTICATION);
        if (StringUtils.isNotBlank(token)) {
            roleName = (String) getUserInfo(token).get(IdmUserInfoConstants.ROLE_NAMES);
        }
        return roleName;
    }


}
