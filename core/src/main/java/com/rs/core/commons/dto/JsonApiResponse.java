package com.rs.core.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Author: Oleh Osyka
 * Date: 4/25/2016
 * Time: 2:18 PM
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonApiResponse {
    private boolean result;
    private int code;
    private Object data;
    @JsonProperty(value = "error_code")
    private int errorCode;
    private String message;

    public static JsonApiResponse newResponse() {
        return new JsonApiResponse();
    }

    public JsonApiResponse successfull() {
        this.result = true;
        return this;
    }

    public JsonApiResponse failed() {
        this.result = false;
        return this;
    }

    public JsonApiResponse statusCode(int code) {
        this.code = code;
        return this;
    }

    public JsonApiResponse data(Object data) {
        this.data = data;
        return this;
    }

    public JsonApiResponse error(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        return this;
    }

    /**
     * Just for Jackson @ResponseBody conversion
     */
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public <CLASS> CLASS getData(Class<CLASS> clazz) throws ClassCastException {
        return new ObjectMapper().convertValue(data, clazz);
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
