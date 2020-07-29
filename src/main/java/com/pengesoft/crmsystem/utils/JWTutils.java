package com.pengesoft.crmsystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pengesoft.crmsystem.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTutils {
    private String secret = "asd';./jasdkasd]ljh/.';.uags.dhjzx'mncsa=-asdk";
    private static final long expiration = 7*24*3600*1000;
    private String header;

    public String getToken(User user) {
        String token = "";
        Date date = new Date(System.currentTimeMillis()+expiration);
        token = JWT.create().withAudience(user.getUserId()).withExpiresAt(date).sign(Algorithm.HMAC256(user.getPassword()));
        System.out.println(token);
        return token;
    }
    /**
     * 从数据声明生成令牌
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 从令牌中获取数据声明
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     * @param user 用户
     * @return 令牌
     */
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", user.getUserId());
        claims.put("created", new Date());
        return generateToken(claims);
    }
    /**
     * 从令牌中获取用户名
     * @param token 令牌
     * @return 用户名
     */
    public int getUserIdFromToken(String token) {
        int UserId;
        try {
            Claims claims = getClaimsFromToken(token);
            UserId = Integer.parseInt(claims.getSubject());
        } catch (Exception e) {
            UserId = 0;
        }
        return UserId;
    }
    /**
     * 从令牌中获取用户名
     * @param token 令牌
     * @return 用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     * @param token       令牌
     * @param user 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, User user) {
        String username = getUserNameFromToken(token);
        return (username.equals(user.getUserName()) && !isTokenExpired(token));
    }
}
