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
public class Project {
    private long id;
    private String Title;
    private Date CreateTime;
    private String Description;
    private String Url;
    private String Tag;
    private byte[] Foto;
}
