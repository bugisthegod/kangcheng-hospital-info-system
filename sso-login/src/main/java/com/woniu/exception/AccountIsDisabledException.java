package com.woniu.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountIsDisabledException extends AuthenticationException {

    public AccountIsDisabledException(String msg) {
        super(msg);
    }
}
