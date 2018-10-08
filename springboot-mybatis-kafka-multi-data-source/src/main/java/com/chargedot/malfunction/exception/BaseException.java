package com.chargedot.malfunction.exception;

/**
 * @Author：caoj
 * @Description：
 * @Data：Created in 2017/12/27
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 3045444670402800197L;

    /**
     * no parametric construction method
     */
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
