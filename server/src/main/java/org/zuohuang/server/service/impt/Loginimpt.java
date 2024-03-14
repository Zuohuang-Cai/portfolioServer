package org.zuohuang.server.service.impt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zuohuang.server.mapper.Adminmapper;
import org.zuohuang.server.mapper.Loginmapper;
import org.zuohuang.server.pojo.DTO.Admin;
import org.zuohuang.server.service.Loginservice;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
@Component
public class Loginimpt implements Loginservice {
    private final Loginmapper loginmapper;
    private final Adminmapper adminmapper;
    private final Admin admin;

    @Autowired
    public Loginimpt(Loginmapper loginmapper, Adminmapper adminmapper, Admin admin) {
        this.loginmapper = loginmapper;
        this.adminmapper = adminmapper;
        this.admin = admin;
    }

    @Autowired
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public String login(Admin admin) {
        HashMap<String, Object> map = new HashMap<>();
        if (loginmapper.login(admin) != null) {
            map.put("name", admin.getUsername());
            map.put("id", loginmapper.login(admin).getId());
            return Jwts.builder()
                    .claims(map)
                    .signWith(key)
                    .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 60 * 60))
                    .compact();
        }
        return "null";
    }

    @Override
    public boolean verify(String token) {
        if (token == null) {
            return false;
        }
        try {
            Claims data = Jwts.parser()
                    .verifyWith((SecretKey) key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            admin.setUsername((String) data.get("name"));
            admin.setLastLoginTime(new Date());
            adminmapper.updateLastLoginTime(admin);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public HashMap<String, Object> getClaims(String token) {
        HashMap<String, Object> claimsMap = new HashMap<>();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        claimsMap.putAll(claims);
        return claimsMap;
    }

    @Override
    public void ip(String ip) {
        Date date = new Date();
        loginmapper.ip(ip, date);
    }
}
