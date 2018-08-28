package com.lzwing.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Author {
    private Long id;
    @JSONField(name="real_name")
    private String realName;
    @JSONField(name="nick_name")
    private String nickName;
}