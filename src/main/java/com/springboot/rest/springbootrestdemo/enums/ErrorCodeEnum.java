package com.springboot.rest.springbootrestdemo.enums;

public enum ErrorCodeEnum {

    EMPLOYEE_NOT_FOUND("employee can not find with this id");

    private final String message;

    ErrorCodeEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
