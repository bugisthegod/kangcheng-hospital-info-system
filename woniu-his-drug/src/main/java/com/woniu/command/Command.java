package com.woniu.command;

public interface Command<T,R> {
    public R execute(T t);
}
