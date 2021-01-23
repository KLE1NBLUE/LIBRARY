package com.zane.bookadmin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * role
 * @author 
 */
@Data
public class Role implements Serializable {
    private Long id;

    private String name;

    private String code;

    private static final long serialVersionUID = 1L;
}