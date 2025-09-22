package com.woniu.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountIsLockedException extends AuthenticationException {

    public AccountIsLockedException(String msg) {
        super(msg);
    }
}
