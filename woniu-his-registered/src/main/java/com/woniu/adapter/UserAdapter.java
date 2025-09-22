package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.UserMapper;
import com.woniu.outlet.po.User;
import com.woniu.outlet.po.UserExample;
import com.woniu.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Transactional
public class UserAdapter {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate template;

    public String registerUser(User user){
        String phone = user.getPhone();
        UserExample example = new UserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()>0){
            if(!users.get(0).getStatus().equals(User.NOTACTIVE)){
                throw new ServiceException("该手机号已被注册");
            }
            //已注册但未激活的删了再加
            userMapper.deleteByPrimaryKey(users.get(0).getId());
        }
        user.setStatus(User.NOTACTIVE);
        userMapper.insertSelective(user);
        //生成激活码
        Integer num = (int) (Math.random()*10000);
        String handle = "";
        if(num<10){
            handle = "000"+num;
        }else if(num<100){
            handle = "00"+num;
        }else if(num<1000){
            handle = "0"+num;
        }else{
            handle = ""+num;
        }
        //激活码存redis用于验证
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(phone,handle,5, TimeUnit.MINUTES);
        return handle;
    }

    public Integer activateUser(String phone,String handle){
        ValueOperations<String, String> ops = template.opsForValue();
        String code = ops.get(phone);
        if(!handle.equals(code)){
            throw new ServiceException("激活码错误，激活失败");
        }
        UserExample example = new UserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(example);
        User user = users.get(0);
        user.setStatus(User.ABLED);
        userMapper.updateByPrimaryKeySelective(user);
        template.delete(phone);
        return 1;
    }

    public String doLogin(User user) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if(users.size()==0){
            throw new ServiceException("账户或密码错误");
        }
        User loginUser = users.get(0);
        if(loginUser.getStatus().equals(User.NOTACTIVE)){
            throw new ServiceException("账户未激活");
        }
        if(loginUser.getStatus().equals(User.DISABLED)){
            throw new ServiceException("账户被禁用，请联系管理员");
        }
        String sign = JwtTokenUtil.createSign(user.getPhone());
        return sign;
    }
}
