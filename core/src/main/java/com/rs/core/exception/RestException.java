package com.rs.core.exception;

/**
 * Author: Oleh Osyka
 * Date: 4/26/2016
 * Time: 5:15 PM
 */
public class RestException extends RuntimeException{

    private int statusCode;
    private int errorCode;

    public RestException(String message, int statusCode, int errorCode) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public RestException(String message, Throwable cause, int statusCode, int errorCode) {
        super(message, cause);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
