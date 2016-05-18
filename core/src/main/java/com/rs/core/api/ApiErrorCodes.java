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

    // Pay 10151-...
    public static final int TOKEN_CREATION_FAILED = 10151;
    public static final int CHARGE_CREATION_FAILED = 10152;
    public static final int CHARGE_CAPTURE_FAILED = 10153;
    public static final int CHARGE_RETRIEVE_FAILED = 10154;
    public static final int EMPTY_CHARGE_RETRIEVE = 10155;
}
