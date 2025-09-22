package com.woniu.command.usercommand;

import com.woniu.command.Command;
import com.woniu.service.impl.UserCommand;
import com.woniu.utils.ApplicationContextHolder;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class ActivateUserCommand implements Command<Map<String,String>,Integer> {

    private UserCommand command;

    public ActivateUserCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(UserCommand.class);
    }

    @Override
    public Integer handle(Map<String, String> map) {
        return this.command.activateUser(map.get("phone"),map.get("handle"));
    }
}
