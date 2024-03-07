package org.zuohuang.server.service.impt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zuohuang.server.dao.Adminmapper;
import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.service.Adminservice;


@Service
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adminimpt implements Adminservice {
    @Autowired
    private Adminmapper adminmapper;

    @Override
    public void create(Admin admin) {
        adminmapper.create(admin);
    }

    @Override
    public void update(Admin admin) {
        adminmapper.update(admin);
    }
}
