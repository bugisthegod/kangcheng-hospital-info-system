package com.woniu.command;

public interface Command <T,R>{
    R handle(T t);
}
