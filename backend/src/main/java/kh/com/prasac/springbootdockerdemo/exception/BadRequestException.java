package kh.com.prasac.springbootdockerdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 18/02/2021 13:18.
 * Position : Senior Application Development Officer
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private int code;

    public BadRequestException(String message) {
        super(message);
        this.code = HttpStatus.BAD_REQUEST.value();
    }

    public BadRequestException(String message,int code) {
        super(message);
        this.code = code;
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}