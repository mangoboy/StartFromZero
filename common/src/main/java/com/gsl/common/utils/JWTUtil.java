package com.gsl.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gsl.common.constants.TokenConstants;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    private static final String JWT_SECRET = TokenConstants.SECRET;

    private static final String CLAIM_ROLE_IDS = "roleIds";
    private static final String CLAIM_USER_ACCOUNT = "userAccount";
    private static final String CLAIM_NAME = "name";
    private static final String CLAIM_MOBILE = "mobile";
    private static final String CLAIM_USER_ID = "userId";
    private static final String CLAIM_ROLE_NAMES = "roleNames";
    private static final String CLAIM_IAT = "iat";


    /**
     * JWT 生成Token
     *
     * @param params 参数map
     * @return
     * @throws Exception
     */
    public static String createToken(Map<String, String> params) {
        Date iatDate = new Date();
        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        JWTCreator.Builder builder = JWT.create().withHeader(map);
        for (Map.Entry<String, String> preMap : params.entrySet()) {
            builder = builder.withClaim(preMap.getKey(), preMap.getValue());
        }
        String token = builder.withIssuedAt(iatDate).sign(Algorithm.HMAC256(JWT_SECRET));
        return token;
    }

    /**
     * 解密token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWT_SECRET)).build();
        jwt = verifier.verify(token);
        return jwt.getClaims();
    }

}
