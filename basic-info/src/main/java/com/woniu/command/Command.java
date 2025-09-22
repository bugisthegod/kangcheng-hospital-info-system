package com.woniu.command;

public interface Command<T,R>{

    public R excute(T t);
}

