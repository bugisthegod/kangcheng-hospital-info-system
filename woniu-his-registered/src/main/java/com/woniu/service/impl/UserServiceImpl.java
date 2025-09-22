package com.woniu.service.impl;

import com.woniu.adapter.UserAdapter;
import com.woniu.outlet.po.User;
import com.woniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAdapter userAdapter;

    @Override
    public String doLogin(User user) throws Exception {
        return userAdapter.doLogin(user);
    }
}
