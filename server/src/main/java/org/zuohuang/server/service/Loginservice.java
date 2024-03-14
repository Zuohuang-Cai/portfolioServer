package org.zuohuang.server.service;

import org.zuohuang.server.pojo.DTO.Admin;

import java.lang.reflect.Array;
import java.util.HashMap;

public interface Loginservice {
    String login(Admin admin);

    boolean verify(String token);

    HashMap<String, Object> getClaims(String token);

    void ip(String ip);

}
