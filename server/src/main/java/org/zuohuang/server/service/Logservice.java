package org.zuohuang.server.service;

import org.zuohuang.server.pojo.DTO.Log;

public interface Logservice {
    void editlogs(Log log);

    void deletelogs(Log log);

    void addlogs(Log log);

    void readlogs(Log log);
}
