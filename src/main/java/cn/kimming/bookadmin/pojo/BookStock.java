package cn.kimming.bookadmin.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * bookstock
 * @author 
 */
@Data
public class BookStock implements Serializable {
    private Long id;

    private Integer stock;

    private Integer totalStock;

    private Long bookId;

    private Book book;

    private static final long serialVersionUID = 1L;

    public BookStock() {
    }

    public BookStock(Long bookId) {
        this.stock = 0;
        this.totalStock = 0;
        this.bookId = bookId;
    }
}