package com.zane.bookadmin.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * category
 * @author 
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String code;


}