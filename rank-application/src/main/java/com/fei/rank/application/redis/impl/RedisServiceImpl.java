package com.fei.rank.application.redis.impl;

import com.ecsage.redis.service.SingleJedisTemplate;
import com.fei.rank.application.redis.RedisService;
import com.fei.rank.application.support.FeiShuUserInfoView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    @Qualifier("rankRedis")
    private SingleJedisTemplate jedisTemplate;

    private static final String employee = "EMPLOYEE";

    private static final String employee_key = "EMPLOYEE_KEY";

    private static final String subject = "fs-ecsage-02";

    @Override
    public FeiShuUserInfoView getEmployeeByEmpId(String employeeId) {
        if(StringUtils.isBlank(employeeId)){
            return null;
        }
        try {
            Object o = jedisTemplate.hash().get(employee, employeeId);
            FeiShuUserInfoView view=(FeiShuUserInfoView) o;
            return view;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getKey() {
        try {
            Object o = jedisTemplate.value().get(employee_key);
            String view=(String) o;
            return view;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
