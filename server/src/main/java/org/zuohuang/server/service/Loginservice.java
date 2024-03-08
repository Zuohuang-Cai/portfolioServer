package org.zuohuang.server.service;

import org.zuohuang.server.pojo.Admin;

public interface Loginservice {
    String login(Admin admin);

    boolean verify(String token);

    void ip(String ip);

}
