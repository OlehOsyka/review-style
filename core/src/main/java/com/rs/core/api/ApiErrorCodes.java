package com.rs.core.api;

/**
 * Author: Oleh Osyka
 * Date: 4/25/2016
 * Time: 4:55 PM
 */
public final class ApiErrorCodes {

    // Auth 10101-10150
    public static final int UNHANDLED_ERROR = 10101;
    public  static final int ACCESS_DENIED = 10102;
    public static final int REGISTRATION_FAILURE = 10103;

    // Git 10151-...
    public static final int DOWNLOAD_REPOSITORY_FAILED = 10151;
    public static final int GET_CONTRIBUTORS_FAILED = 10152;
    public static final int CONNECT_FAILED = 10153;
    public static final int EMPTY_TREE = 10154;

    // Base 20100-...
    public static final int EMPTY_VCS_ADDRESS = 20100;
    public static final int EMPTY_PROJECT_NAME = 20101;
}
