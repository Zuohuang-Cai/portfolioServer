package org.zuohuang.server.service.impt;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zuohuang.server.mapper.Logmapper;
import org.zuohuang.server.pojo.DTO.Log;
import org.zuohuang.server.service.Logservice;

import java.util.Date;

@Service
@Component
public class Logimpt implements Logservice {
    @Autowired
    private Logmapper logmapper;

    @Override
    public void editlogs(Log log) {
        logmapper.addlogs(log);
    }

    @Override
    public void deletelogs(Log log) {

    }

    @Override
    public void addlogs(Log log) {

    }

    @Override
    public void readlogs(Log log) {

    }
}
