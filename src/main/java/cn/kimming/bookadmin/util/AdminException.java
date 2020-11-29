package cn.kimming.bookadmin.util;


public class AdminException extends RuntimeException{
    public AdminException(String message) {
        super(message);
    }

    public AdminException(String message, Throwable cause) {
        super(message, cause);
    }
}
