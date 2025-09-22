package com.woniu.command.usercommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.User;
import com.woniu.service.impl.UserCommand;
import com.woniu.utils.ApplicationContextHolder;

public class RegisterUserCommand implements Command<User,String> {

    private UserCommand command;

    public RegisterUserCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(UserCommand.class);
    }

    @Override
    public String handle(User user) {
        return this.command.registerUser(user);
    }
}
