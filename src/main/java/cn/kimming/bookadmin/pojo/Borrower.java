package cn.kimming.bookadmin.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * borrower
 * @author 
 */
@Data
public class Borrower implements Serializable {
    private Long id;

    private String name;

    private String phone;

    private String idCard;

    /**
     * 状态: 0:冻结 1:启动
     */
    private Integer status;

    private Date insertTime;    // 注册时间

    private static final long serialVersionUID = 1L;
}