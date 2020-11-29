package cn.kimming.bookadmin.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * borrowing
 * @author 
 */
@Data
public class Borrowing implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final short STATUS_BORROWING = 0; // 借阅状态: 借阅中
    public static final short STATUS_OVERTIME_BORROWING = 1; // 借阅状态: 超时借阅
    public static final short STATUS_OVERTIME_RETURNED = 2; // 借阅状态: 超时归还
    public static final short STATUS_RETURNED = 3; // 借阅状态: 已归还
    public static final short STATUS_LOST = 4; // 借阅状态: 丢失/损坏

    private Long id;

    /**
     * 借阅时间
     */
    private Date borrowTime;

    /**
     * 归还时间
     */
    private Date returnTime;

    /**
     * 状态: 0.借阅中. 1.超时借阅 2.超时归还 3.已归还 4.丢失/损坏
     */
    private Short status;

    /**
     * 借阅人
     */
    private Long borrowerId;

    /**
     * 借阅的图书
     */
    private Long bookId;

    private Borrower borrower;
    private Book book;


}