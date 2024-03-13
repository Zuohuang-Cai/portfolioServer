package org.zuohuang.server.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Admin {
    private String username;
    private String password;
    private Date CreateTime;
    private Date LastLoginTime;

}
