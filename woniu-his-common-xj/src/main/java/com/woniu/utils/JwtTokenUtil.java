package com.woniu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtTokenUtil {

    // public static final String TOKEN_HEADER = "Authorization";
    /**
     * 过期时间50分钟
     */
    private static final long EXPIRE_TIME = 5 * 60 * 10000;
    /**
     * jwt 密钥
     */
    private static final String SECRET = "xiaokongming";

    /*
    生成签名  50分钟过期
     */
    public static String createSign(String userName) throws Exception {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    // 将 user id 保存到 token 里面
                    .withAudience(userName)
                    // 50分钟后token过期
                    .withExpiresAt(date)
                    //.withClaim()
                    //.withSubject(userName)
                    // token 的密钥
                    .sign(algorithm);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("签名错误");
        }
    }

    /**
     * 根据token获取username
     *
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        String userId = null;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            userId = null;
        }
        return userId;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
            //throw new JWTVerificationException("token 无效，请重新获取");
        }
    }

    //是否已过期
    public static boolean isExpiration(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private static Claims getTokenBody(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return claims;
    }
}
