package com.mudemo.model;

import lombok.Data;

/**
 * @author guozhengMu
 * @version 1.0
 * @date 2019/8/26 16:16
 * @description
 * @modify
 */
@Data
public class Goods {
    private int id;
    private String name;
    private String type;
    private double price;
    private int size;
    private int status;
    private String description;
}
