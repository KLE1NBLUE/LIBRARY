package cn.kimming.bookadmin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * book
 * @author 
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String code;

    private String author;

    private Long categoryId;

    private Long publisherId;

    private Category category;

    private Publisher publisher;


}