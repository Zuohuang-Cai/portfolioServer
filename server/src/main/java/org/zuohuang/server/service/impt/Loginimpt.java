package org.zuohuang.server.service.impt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zuohuang.server.dao.Loginmapper;
import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.service.Loginservice;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
@Component
public class Loginimpt implements Loginservice {
    private Loginmapper loginmapper;

    @Autowired
    public Loginimpt(Loginmapper loginmapper) {
        this.loginmapper = loginmapper;
    }

    @Autowired
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public String login(Admin admin) {
        System.out.println(loginmapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", admin.getUsername());
        if (loginmapper.login(admin) != null) {
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
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void ip(String ip) {
        System.out.println(loginmapper);
        Date date = new Date();
        loginmapper.ip(ip, date);
    }
}
