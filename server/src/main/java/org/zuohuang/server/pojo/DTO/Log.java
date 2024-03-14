package org.zuohuang.server.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private int admin_id;
    private String type;
    private String CreateTime;
    private String info;
}
