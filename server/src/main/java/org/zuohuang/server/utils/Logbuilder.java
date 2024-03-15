package org.zuohuang.server.utils;

import org.zuohuang.server.pojo.DTO.Log;

public class Logbuilder {
    private int adminId;
    private String type;
    private String info;

    public Logbuilder setAdminId(int adminId) {
        this.adminId = adminId;
        return this;
    }

    public Logbuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Logbuilder setInfo(String info) {
        this.info = info;
        return this;
    }

    public Log build() {
        Log log = new Log();
        log.setAdmin_id(adminId);
        log.setType(type);
        log.setInfo(info);
        return log;
    }
}