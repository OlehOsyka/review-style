package com.rs.admin.exception;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 4:52 PM
 */
public class ProjectAssignedException extends RuntimeException {

    public ProjectAssignedException() {
    }

    public ProjectAssignedException(String message) {
        super(message);
    }

    public ProjectAssignedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectAssignedException(Throwable cause) {
        super(cause);
    }
}
