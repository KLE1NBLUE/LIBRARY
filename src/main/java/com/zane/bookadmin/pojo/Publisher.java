package com.zane.bookadmin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * publisher
 * @author 
 */
@Data
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String code;

}