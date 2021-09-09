package com.lexical.foodapp.response;

public class ErrorResponse<T> {
    private int code;
    private String status;
    private T errorCode;
    private T message;

    public ErrorResponse(int code, String status, T message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public ErrorResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(T errorCode) {
        this.errorCode = errorCode;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
