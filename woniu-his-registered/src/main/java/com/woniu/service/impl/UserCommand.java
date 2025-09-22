package com.woniu.service.impl;

import com.woniu.adapter.UserAdapter;
import com.woniu.outlet.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCommand {

    @Autowired
    private UserAdapter userAdapter;

    public String registerUser(User user){
        return userAdapter.registerUser(user);
    }

    public Integer activateUser(String phone,String handle){
        return userAdapter.activateUser(phone, handle);
    }

}
