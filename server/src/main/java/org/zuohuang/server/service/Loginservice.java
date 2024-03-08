package org.zuohuang.server.service;

import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.pojo.Result;

public interface Loginservice {
    String login(Admin admin);

    boolean verify(String token);

}
