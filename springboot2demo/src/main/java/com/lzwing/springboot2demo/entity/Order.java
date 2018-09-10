package com.lzwing.springboot2demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/8
 * Time: 21:23
 */
@Data
public class Order implements Serializable{

    private static final long serialVersionUID = 2937765510348871933L;

    private String id;
    private String name;
    private String messageId;
}
