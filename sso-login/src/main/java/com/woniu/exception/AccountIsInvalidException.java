package com.woniu.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountIsInvalidException extends AuthenticationException {

    public AccountIsInvalidException(String msg) {
        super(msg);
    }
}
