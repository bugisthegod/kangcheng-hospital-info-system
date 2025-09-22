package com.woniu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.exception.AccountIsInvalidException;
import com.woniu.outlet.dao.WorkerPoMapper;
import com.woniu.outlet.po.WorkerPo;
import com.woniu.outlet.po.WorkerPoExample;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.security.auth.login.AccountLockedException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private WorkerPoMapper workerPoMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    public UserDetails loadUserByUsername(String username){

            WorkerPoExample example = new WorkerPoExample();
            WorkerPoExample.Criteria criteria = example.createCriteria();
            criteria.andWAccountEqualTo(username);
            List<WorkerPo> workerPos = workerPoMapper.selectByExample(example);

            if (workerPos.size() == 0) { //没有用户
                return null;
            }
            if (workerPos.get(0).getWStatus().equals(WorkerPo.DISABLE)) {
                throw new AccountLockedException("该员工账户被禁用,请联系管理员");
            } else if (workerPos.get(0).getWStatus().equals(WorkerPo.QUIT)) {
                throw new AccountIsInvalidException("该员工已离职,账号失效");
            }
        //用户名存在,比较密码
        String password = workerPos.get(0).getWPassword(); // 数据库的密码
        //redis的list对象
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        List<GrantedAuthority> list = new ArrayList<>();  //权限集合
        //先从redis中取权限集合
        List<String> permsCodes = new ArrayList<>();
        String s = opsForValue.get("HisPerms" + username);
        if (StringUtils.isEmpty(s)) {
            //没有就从数据库取
            permsCodes = workerPoMapper.findPermsByName(username);
            log.info("从数据库取得");
            //并存入redis
            opsForValue.set("HisPerms"+username,objectMapper.writeValueAsString(permsCodes));
        } else {
            log.info("redis中取得");
        }
        permsCodes.forEach(item -> {
            list.add(new SimpleGrantedAuthority(item));
        });
        return new User(username,password,list);
    }
}
